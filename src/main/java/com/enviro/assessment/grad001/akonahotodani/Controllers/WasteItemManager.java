package com.enviro.assessment.grad001.akonahotodani.Controllers;

import com.enviro.assessment.grad001.akonahotodani.DTOs.AddNewItemDTO;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteCategory;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import com.enviro.assessment.grad001.akonahotodani.Services.WasteCategoryService;
import com.enviro.assessment.grad001.akonahotodani.Services.WasteItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("waste_items")
@CrossOrigin("*")
public class WasteItemManager {
    private final WasteCategoryService wasteCategoryService;
    private final WasteItemService wasteItemService;

    public WasteItemManager(WasteItemService wasteItemService,WasteCategoryService wasteCategoryService) {

        this.wasteItemService = wasteItemService;
        this.wasteCategoryService = wasteCategoryService;
    }
    @GetMapping(path = "items")
    public List<WasteItem> getAllItems() {
        return this.wasteItemService.getAllWasteItems();
    }
    @PostMapping(path = "item")
    public WasteItem getItem( @RequestBody WasteItem item) {
        return this.wasteItemService.getItemByID(item);
    }
    @PostMapping(path = "RemoveItem")
    public Boolean removeItem( @RequestBody WasteItem item) {

        WasteItem exists= this.wasteItemService.getItemByID(item);
        if(exists!=null){
            exists.setCategory(null);
            this.wasteItemService.removeItems(exists);
            return true;
        }
        //item does not exist in db
        return false;
    }
    @PostMapping("/updateItem")
    public WasteItem  updateItem(@Valid @RequestBody WasteItem item){

            WasteItem exists= this.wasteItemService.getItemByID(item);
            if(exists!=null){
                exists.setName(item.getName());
                exists.setMaterial(item.getMaterial());
                this.wasteItemService.addItem(exists);
                return exists;
            }
            //Could not update this item
            return null;
    }
    @PostMapping("/addItem")
    public WasteItem  addItem(@Valid @RequestBody AddNewItemDTO DTO){

        WasteCategory category=this.wasteCategoryService.getCategoryByName(DTO.getCategoryName());
        WasteItem exists= this.wasteItemService.getItem(DTO.getItem());
        if(exists==null){
            exists=new WasteItem(DTO.getItem().getName(),DTO.getItem().getMaterial());
            exists.setCategory(category);
            exists=this.wasteItemService.addItem(exists);

            category.addToItemsList(exists);
            this.wasteCategoryService.addCategory(category);

        }
        return exists;
    }
}
