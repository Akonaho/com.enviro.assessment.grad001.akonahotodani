package com.enviro.assessment.grad001.akonahotodani.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "waste_items")
@Data
public class WasteItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Material is mandatory")
    private String material;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
//    @NotEmpty(message = "category is mandatory")
    private WasteCategory category;


    public WasteItem() {
    }
    public WasteItem(String name, String material) {
        this.name=name;
        this.material=material;
    }

    public WasteCategory getCategory() {
        return category;
    }

    public void setCategory(WasteCategory items) {
        this.category = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

//    public WasteCategory getCategory() {
//        return category;
//    }
//
//    public void setCategory(WasteCategory category) {
//        this.category = category;
//    }
//
//    public List<DisposalGuideline> getGuidelines() {
//        return guidelines;
//    }
//
//    public void setGuidelines(List<DisposalGuideline> guidelines) {
//        this.guidelines = guidelines;
//    }
//
//    public List<RecyclingTip> getTips() {
//        return tips;
//    }
//
//    public void setTips(List<RecyclingTip> tips) {
//        this.tips = tips;
//    }

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_id")
//    private WasteCategory category;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "guideline_id")
//    private List<DisposalGuideline> guidelines;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "tip_id")
//    private List<RecyclingTip> tips;
}
