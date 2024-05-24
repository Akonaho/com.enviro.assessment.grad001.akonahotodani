package com.enviro.assessment.grad001.akonahotodani.Repositories;

import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WasteItemRepository extends JpaRepository<WasteItem, Long> {
    WasteItem getWasteItemByNameAndMaterial(String n, String m);
    WasteItem getWasteItemById(Long id);
}
