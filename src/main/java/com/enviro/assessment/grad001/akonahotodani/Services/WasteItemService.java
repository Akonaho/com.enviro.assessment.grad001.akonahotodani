package com.enviro.assessment.grad001.akonahotodani.Services;

import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import com.enviro.assessment.grad001.akonahotodani.Repositories.WasteItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteItemService {
    private WasteItemRepository repository;

    public WasteItemService(WasteItemRepository repository){
        this.repository = repository;
    }
    public WasteItem addItem( WasteItem item)
    {
        return repository.save(item);
    }
    public List<WasteItem> getAllWasteItems()
    {
        return repository.findAll();
    }
    public void removeItems(WasteItem item)
    {
        repository.delete(item);
    }
    public WasteItem getItem( WasteItem item)
    {
        return repository.getWasteItemByNameAndMaterial(item.getName(), item.getMaterial());
    }
    public WasteItem getItemByID( WasteItem item)
    {
        return repository.getWasteItemById(item.getId());
    }
}
