package com.enviro.assessment.grad001.akonahotodani.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddCategoryDTO {
    //The name of the category being added
    @NotBlank(message = "A category name cannot be blank")
    private String name;
    //A description of the waste category
    @NotBlank(message = "A category description cannot be blank")
    private String description;
}
