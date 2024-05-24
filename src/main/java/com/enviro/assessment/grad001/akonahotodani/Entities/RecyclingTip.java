package com.enviro.assessment.grad001.akonahotodani.Entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Table(name = "recycling_tips")
@Data
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Recycling tip cannot be blank")
    private String tip;

    //You can get recycling tips based on the material you want to recycle
    private String material;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private WasteItem item;
}
