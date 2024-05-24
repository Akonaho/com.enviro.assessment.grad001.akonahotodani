package com.enviro.assessment.grad001.akonahotodani.Repositories;

import com.enviro.assessment.grad001.akonahotodani.Entities.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long>{
        WasteCategory getWasteCategoryByName(String name);
        WasteCategory getWasteCategoryById(Long id);
//        List<WasteCategory> getWasteCategoryByName(String name);
}