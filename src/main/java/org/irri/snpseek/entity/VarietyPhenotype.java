package org.irri.snpseek.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "variety_phenotypes")
public class VarietyPhenotype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long varietyId;
    private String phenId;
    private String value;
    
    public VarietyPhenotype() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getVarietyId() { return varietyId; }
    public void setVarietyId(Long varietyId) { this.varietyId = varietyId; }
    
    public String getPhenId() { return phenId; }
    public void setPhenId(String phenId) { this.phenId = phenId; }
    
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}