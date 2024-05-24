package com.enviro.assessment.grad001.akonahotodani.Controllers;


import com.enviro.assessment.grad001.akonahotodani.Entities.DisposalGuideline;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteCategory;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import com.enviro.assessment.grad001.akonahotodani.Services.DisposalGuidelineService;
import com.enviro.assessment.grad001.akonahotodani.Services.WasteCategoryService;
import com.enviro.assessment.grad001.akonahotodani.Services.WasteItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("guidelines")
@CrossOrigin("*")
public class DisposalGuidelineManager {
    private final DisposalGuidelineService disposalGuidelineService;
    private final WasteItemService wasteItemService;
    private final WasteCategoryService wasteCategoryService;

    public DisposalGuidelineManager(WasteCategoryService wasteCategoryService, DisposalGuidelineService disposalGuidelineService, WasteItemService wasteItemService) {

        this.disposalGuidelineService = disposalGuidelineService;
        this.wasteItemService = wasteItemService;
        this.wasteCategoryService = wasteCategoryService;
    }
    @GetMapping(path = "guidelines")
    public List<DisposalGuideline> getAllGuidelines()
    {
        return this.disposalGuidelineService.getAllGuidelines();
    }
    @PostMapping(path = "guidelineByItem")
    public List<DisposalGuideline> getGuidelineByItem(@Valid @RequestBody WasteItem item) {
        WasteItem _item= this.wasteItemService.getItemByID(item);
        if(_item!=null){
            List<DisposalGuideline> exists= this.disposalGuidelineService.getGuidelineForItem(_item);
            if(exists!=null){
                return exists;
            }
            //No tips exist:: *you could get tips by the material of the item instead
            return null;
        }
        throw new RuntimeException("Waste item is null");
    }
    @PostMapping(path = "guidelinesByCategory")
    public List<DisposalGuideline> getGuidelinesByCategory(@Valid @RequestBody WasteCategory cat) {
        return this.disposalGuidelineService.getGuidelinesByCategory(cat.getName());
    }
    @PostMapping(path = "guidelinesByMaterial")
    public List<DisposalGuideline> getGuidelinesByMaterial(@Valid @RequestBody WasteItem item) {
        return this.disposalGuidelineService.getGuidelinesByMaterial(item.getMaterial());
    }
    @PostMapping(path = "RemoveGuideline")
    public Boolean removeGuideline(@Valid @RequestBody DisposalGuideline guideline) {


        DisposalGuideline exists= this.disposalGuidelineService.getGuidelineByID(guideline);
        exists.setItem(null);
        this.disposalGuidelineService.removeGuideline(exists);

        //check if record was removed
        exists= this.disposalGuidelineService.getGuidelineByID(guideline);
        if(exists!=null){
            return false;
        }
        return true;
    }
    @PostMapping("/updateGuideline")
    public DisposalGuideline updateTip(@Valid @RequestBody DisposalGuideline guideline){
        DisposalGuideline exists= this.disposalGuidelineService.getGuidelineByID(guideline);
        if(exists!=null){
            //You can only change the details of the tip
            exists.setGuideline(guideline.getGuideline());
            exists.setCategory(guideline.getCategory());
            exists.setMaterial(guideline.getMaterial());
            this.disposalGuidelineService.addGuideline(exists);
            return exists;
        }
        //Could not update this tip
        throw new RuntimeException("Guideline does not exist :: Could not Update guideline.");

    }
    @PostMapping("/addGuideline")
    public DisposalGuideline  addGuideline(@Valid @RequestBody DisposalGuideline guideline){

        WasteItem item = this.wasteItemService.getItem(guideline.getItem());
        if (item != null) {
            List<DisposalGuideline> exists = this.disposalGuidelineService.getGuidelineForItem(item);
            if (exists != null) {
                for (int i = 0; i < exists.size(); i++) {
                    if (exists.get(i).getGuideline().equals(guideline.getGuideline())) {
                        return exists.get(i);
                    }
                }

                DisposalGuideline newguideline= new DisposalGuideline();

                newguideline.setItem(item);
                newguideline.setMaterial(guideline.getMaterial());
                newguideline.setCategory(guideline.getCategory());
                newguideline.setGuideline(guideline.getGuideline());

                return this.disposalGuidelineService.addGuideline(newguideline);
            }else{
                DisposalGuideline newguideline = new DisposalGuideline();

                newguideline.setItem(item);
                newguideline.setMaterial(guideline.getMaterial());
                newguideline.setGuideline(guideline.getGuideline());

                return this.disposalGuidelineService.addGuideline(newguideline);
            }

        } else {
            item = new WasteItem(guideline.getItem().getName(), guideline.getItem().getMaterial());
            WasteCategory cat = this.wasteCategoryService.getCategoryByName(guideline.getItem().getCategory().getName());
            item.setCategory(cat);
            this.wasteItemService.addItem(item);
            item = this.wasteItemService.getItem(guideline.getItem());

            DisposalGuideline newTip = new DisposalGuideline();

            newTip.setItem(item);
            newTip.setMaterial(guideline.getMaterial());
            newTip.setCategory(guideline.getCategory());
            newTip.setGuideline(guideline.getGuideline());

            return this.disposalGuidelineService.addGuideline(newTip);
        }

    }

}