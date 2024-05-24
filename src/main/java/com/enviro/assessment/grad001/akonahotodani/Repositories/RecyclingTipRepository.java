package com.enviro.assessment.grad001.akonahotodani.Repositories;

import com.enviro.assessment.grad001.akonahotodani.Entities.RecyclingTip;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
        RecyclingTip getRecyclingTipById(Long id);
        RecyclingTip getRecyclingTipByTip(String tip);
        List<RecyclingTip> getRecyclingTipByMaterial(String material);
        List<RecyclingTip> getRecyclingTipByItem(WasteItem item);
}
