package com.enviro.assessment.grad001.akonahotodani.Controllers;

import com.enviro.assessment.grad001.akonahotodani.DTOs.AddCategoryDTO;
import com.enviro.assessment.grad001.akonahotodani.DTOs.AddItemToCategoryDTO;
import com.enviro.assessment.grad001.akonahotodani.Entities.RecyclingTip;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteCategory;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import com.enviro.assessment.grad001.akonahotodani.Services.RecyclingTipService;
import com.enviro.assessment.grad001.akonahotodani.Services.WasteCategoryService;
import com.enviro.assessment.grad001.akonahotodani.Services.WasteItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tips")
@CrossOrigin("*")
public class RecyclingTipManager {
    private final RecyclingTipService recyclingTipService;
    private final WasteItemService wasteItemService;
    private final WasteCategoryService wasteCategoryService;

    public RecyclingTipManager(WasteCategoryService wasteCategoryService, RecyclingTipService recyclingTipService, WasteItemService wasteItemService) {

        this.recyclingTipService = recyclingTipService;
        this.wasteItemService = wasteItemService;
        this.wasteCategoryService = wasteCategoryService;
    }
    @GetMapping(path = "tips")
    public List<RecyclingTip> getAllTips()
    {
        return this.recyclingTipService.getAllTips();
    }
    @PostMapping(path = "tipByItem")
    public List<RecyclingTip> getTip(@Valid @RequestBody WasteItem item) {
        WasteItem _item= this.wasteItemService.getItemByID(item);
        if(_item!=null){
            List<RecyclingTip> exists= this.recyclingTipService.getTipForItem(_item);
            if(exists!=null){
                return exists;
            }
            //No tips exist:: you could get tips by the material of the item instead
            return null;
        }
        throw new RuntimeException("Waste item is null");
    }
    @PostMapping(path = "tipsByMaterial")
    public List<RecyclingTip> getTipByMaterial(@Valid @RequestBody WasteItem item) {

        return this.recyclingTipService.getTipsByMaterial(item.getMaterial());
    }
    @PostMapping(path = "RemoveTip")
    public Boolean removeTip(@Valid @RequestBody RecyclingTip tip) {
        RecyclingTip exists= this.recyclingTipService.getTipByID(tip);
        exists.setItem(null);
        this.recyclingTipService.removeTip(exists);

        //check if record was removed
        exists= this.recyclingTipService.getTipByID(tip);
        if(exists!=null){
            return false;
        }
        return true;
    }
    @PostMapping("/updateTip")
    public RecyclingTip updateTip(@Valid @RequestBody RecyclingTip tip){

        RecyclingTip exists= this.recyclingTipService.getTipByID(tip);
        if(exists!=null){
            //You can only change the details of the tip
            exists.setTip(tip.getTip());
            this.recyclingTipService.addTip(exists);
            return exists;
        }
        //Could not update this tip
        throw new RuntimeException("Recycling tip does not exist");
    }
    @PostMapping("/addTip")
    public RecyclingTip  addItem(@Valid @RequestBody RecyclingTip tip) {
        WasteItem item = this.wasteItemService.getItem(tip.getItem());
        if (item != null) {
            List<RecyclingTip> exists = this.recyclingTipService.getTipForItem(item);
            if (exists != null) {
                for (int i = 0; i < exists.size(); i++) {
                    if (exists.get(i).getTip().equals(tip.getTip())) {
                        return exists.get(i);
                    }
                }

                RecyclingTip newTip = new RecyclingTip();

                newTip.setItem(item);
                newTip.setMaterial(tip.getMaterial());
                newTip.setTip(tip.getTip());

                return this.recyclingTipService.addTip(newTip);
            }else{
                RecyclingTip newTip = new RecyclingTip();

                newTip.setItem(item);
                newTip.setMaterial(tip.getMaterial());
                newTip.setTip(tip.getTip());

                return this.recyclingTipService.addTip(newTip);
            }

        } else {
            item = new WasteItem(tip.getItem().getName(), tip.getItem().getMaterial());
            WasteCategory cat = this.wasteCategoryService.getCategoryByName(tip.getItem().getCategory().getName());
            item.setCategory(cat);
            this.wasteItemService.addItem(item);
            item = this.wasteItemService.getItem(tip.getItem());

            RecyclingTip newTip = new RecyclingTip();

            newTip.setItem(item);
            newTip.setMaterial(tip.getMaterial());
            newTip.setTip(tip.getTip());

            return this.recyclingTipService.addTip(newTip);
        }
    }

}
