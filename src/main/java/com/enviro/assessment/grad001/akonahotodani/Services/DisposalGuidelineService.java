package com.enviro.assessment.grad001.akonahotodani.Services;

import com.enviro.assessment.grad001.akonahotodani.Entities.DisposalGuideline;
import com.enviro.assessment.grad001.akonahotodani.Entities.RecyclingTip;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteCategory;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import com.enviro.assessment.grad001.akonahotodani.Repositories.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.akonahotodani.Repositories.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {
    private DisposalGuidelineRepository repository;
    public DisposalGuidelineService(DisposalGuidelineRepository repository){
        this.repository = repository;
    }


    public DisposalGuideline addGuideline( DisposalGuideline guideline)
    {
        return repository.save(guideline);
    }
    public List<DisposalGuideline> getAllGuidelines()
    {
        return repository.findAll();
    }
    public DisposalGuideline getGuidelineByID(DisposalGuideline guideline) {
        return repository.getDisposalGuidelineById(guideline.getId());
    }
    public void removeGuideline(DisposalGuideline guideline)
    {
        repository.delete(guideline);
    }
    public List<DisposalGuideline>  getGuidelinesByMaterial( String material) {
        return repository.getDisposalGuidelinesByMaterial(material);
    }
    public List<DisposalGuideline>  getGuidelinesByCategory( String cat) {
        return repository.getDisposalGuidelinesByCategory(cat);
    }
    public List<DisposalGuideline> getGuidelineForItem(WasteItem item) {
        return repository.getDisposalGuidelinesByItem(item);
    }
}
