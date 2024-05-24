package com.enviro.assessment.grad001.akonahotodani.Controllers;

import com.enviro.assessment.grad001.akonahotodani.DTOs.AddCategoryDTO;
import com.enviro.assessment.grad001.akonahotodani.DTOs.AddItemToCategoryDTO;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteCategory;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import com.enviro.assessment.grad001.akonahotodani.Services.WasteCategoryService;
import com.enviro.assessment.grad001.akonahotodani.Services.WasteItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@CrossOrigin("*")
public class CategoryManager {
    private final WasteCategoryService wasteCategoryService;
    private final WasteItemService wasteItemService;

    public CategoryManager(WasteCategoryService wasteCategoryService, WasteItemService wasteItemService) {

        this.wasteCategoryService = wasteCategoryService;
        this.wasteItemService = wasteItemService;
    }
    @GetMapping(path = "/categories")
    public List<WasteCategory> getAllCategories()
    {
        return this.wasteCategoryService.getAllWasteCategory();
    }
    @PostMapping(path = "/categoryByItem")
    public WasteCategory getCategory(@RequestBody WasteItem item) {
        WasteItem exists= this.wasteItemService.getItemByID(item);
        if(exists!=null){
            return exists.getCategory();
        }
        return null;
    }
    @PostMapping(path = "/categoryByID")
    public WasteCategory getCategory( @RequestBody WasteCategory cat) {
        return this.wasteCategoryService.getCategoryByID(cat);
    }
    @PostMapping(path = "/categoryByName")
    public WasteCategory getCategoryByName( @RequestBody WasteCategory cat) {
        return this.wasteCategoryService.getCategoryByName(cat.getName());
    }
    @PostMapping(path = "/RemoveCategory")
    public Boolean removeCategory(@Valid @RequestBody WasteCategory cat) {
        WasteCategory exists= this.wasteCategoryService.getCategoryByID(cat);
        exists.setItems(null);
        this.wasteCategoryService.removeCategory(exists);

        //check if record was removed
        exists= this.wasteCategoryService.getCategoryByName(cat.getName());
        if(exists!=null){
            return false;
        }
        return true;
    }
    @PostMapping("/updateCategory")
    public WasteCategory updateItem( @RequestBody AddItemToCategoryDTO DTO){

        WasteCategory exists= this.wasteCategoryService.getCategoryByName(DTO.getCategory().getName());
        if(exists!=null){
//            exists.setName(DTO.getCategory().getName());
            exists.setDescription(DTO.getCategory().getDescription());

            WasteItem item= this.wasteItemService.getItem(DTO.getItem());
            if(item==null){
                item=new WasteItem(DTO.getItem().getName(),DTO.getItem().getMaterial());
                item.setCategory(exists);
                this.wasteItemService.addItem(item);
            }

            exists.getItems().add(item);

            this.wasteCategoryService.addCategory(exists);
            return exists;
        }
        //Could not update this item
        throw new RuntimeException("Category does not exist");
    }
    @PostMapping("/addCategory")
    public WasteCategory  addItem(@Valid @RequestBody AddCategoryDTO DTO){

        WasteCategory exists= this.wasteCategoryService.getCategoryByName(DTO.getName());
        if(exists==null){
            exists=new WasteCategory();
            exists.setName(DTO.getName());
            exists.setDescription(DTO.getDescription());
            this.wasteCategoryService.addCategory(exists);
        }
        return exists;

    }

}
