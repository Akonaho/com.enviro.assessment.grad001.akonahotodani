package com.enviro.assessment.grad001.akonahotodani.Services;

import com.enviro.assessment.grad001.akonahotodani.Entities.WasteCategory;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import com.enviro.assessment.grad001.akonahotodani.Repositories.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {
    private WasteCategoryRepository repository;
    public WasteCategoryService(WasteCategoryRepository repository){
        this.repository = repository;
    }
    public void addCategory( WasteCategory category)
    {
        repository.save(category);
    }
    public List<WasteCategory> getAllWasteCategory()
    {
        return repository.findAll();
    }
    public void removeCategory(WasteCategory cat)
    {
        repository.delete(cat);
    }
    public WasteCategory getCategoryByID( WasteCategory cat) {
        return repository.getWasteCategoryById(cat.getId());
    }
    public WasteCategory getCategoryByName( String name) {
        return repository.getWasteCategoryByName(name);
    }
}
