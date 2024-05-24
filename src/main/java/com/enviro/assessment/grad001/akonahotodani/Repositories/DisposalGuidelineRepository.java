package com.enviro.assessment.grad001.akonahotodani.Repositories;

import com.enviro.assessment.grad001.akonahotodani.Entities.DisposalGuideline;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
    DisposalGuideline getDisposalGuidelineById(Long id);
    List<DisposalGuideline> getDisposalGuidelinesByCategory(String category);
    List<DisposalGuideline> getDisposalGuidelinesByItem(WasteItem item);
    List<DisposalGuideline> getDisposalGuidelinesByMaterial(String material);
}