package com.enviro.assessment.grad001.akonahotodani.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;



@Entity
@Table(name = "disposal_guidelines")
@Data
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Disposal guideline cannot be blank")
    private String guideline;

    //You can get disposal guidelines based on the material or waste category you want to recycle
    private String material;
    private String category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private WasteItem item;
}
