package com.enviro.assessment.grad001.akonahotodani.DTOs;

import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddNewItemDTO {
    //The name of the category that the new item being added falls under
    @NotBlank(message = "Category cannot be empty")
    private String categoryName;
    //the new waste item being added
    @NotNull(message = "Item cannot be null")
    private WasteItem item;
}
