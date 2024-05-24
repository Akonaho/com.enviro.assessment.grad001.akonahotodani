package com.enviro.assessment.grad001.akonahotodani.DTOs;

import com.enviro.assessment.grad001.akonahotodani.Entities.WasteCategory;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddItemToCategoryDTO {
    //this is the category, as it appears in the database
    @NotNull(message = "Category cannot be null")
    private WasteCategory category;
    //the new item being added to the category above
    @NotNull(message = "Item cannot be null")
    private WasteItem item;
}
