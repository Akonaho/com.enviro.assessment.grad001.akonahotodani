package com.enviro.assessment.grad001.akonahotodani.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "waste_categories")
@Data
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Description is mandatory")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    @JsonIgnore
    private List<WasteItem> items;

    public WasteCategory() {
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public List<WasteItem> getItems() {
        return items;
    }
    public void addToItemsList(WasteItem item){
        this.items.add(item);
    }
    public void setItems(List<WasteItem> items) {
        this.items = items;
    }
}
