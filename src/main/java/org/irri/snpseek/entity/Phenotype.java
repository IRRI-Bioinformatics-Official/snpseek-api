package org.irri.snpseek.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "phenotypes")
public class Phenotype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String phenId;
    private String name;
    private String description;
    
    public Phenotype() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getPhenId() { return phenId; }
    public void setPhenId(String phenId) { this.phenId = phenId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}