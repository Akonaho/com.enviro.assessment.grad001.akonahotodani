package com.enviro.assessment.grad001.akonahotodani.Services;

import com.enviro.assessment.grad001.akonahotodani.Entities.RecyclingTip;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import com.enviro.assessment.grad001.akonahotodani.Repositories.RecyclingTipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {
    private RecyclingTipRepository repository;
    public RecyclingTipService(RecyclingTipRepository repository){
        this.repository = repository;
    }
    public RecyclingTip addTip( RecyclingTip tip)
    {
        return repository.save(tip);
    }
    public List<RecyclingTip> getAllTips()
    {
        return repository.findAll();
    }
    public RecyclingTip getTipByID(RecyclingTip tip)
    {
        return repository.getRecyclingTipById(tip.getId());
    }
    public RecyclingTip getTip(RecyclingTip tip)
    {
        return repository.getRecyclingTipByTip(tip.getTip());
    }
    public void removeTip(RecyclingTip tip)
    {
        repository.delete(tip);
    }
    public List<RecyclingTip>  getTipsByMaterial( String material) {
        return repository.getRecyclingTipByMaterial(material);
    }
    public List<RecyclingTip> getTipForItem(WasteItem item) {
        return repository.getRecyclingTipByItem(item);
    }
}
