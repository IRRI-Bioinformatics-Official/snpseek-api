package org.irri.snpseek.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passports")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long varietyId;
    private String passId;
    private String fieldName;
    private String fieldValue;
    
    public Passport() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getVarietyId() { return varietyId; }
    public void setVarietyId(Long varietyId) { this.varietyId = varietyId; }
    
    public String getPassId() { return passId; }
    public void setPassId(String passId) { this.passId = passId; }
    
    public String getFieldName() { return fieldName; }
    public void setFieldName(String fieldName) { this.fieldName = fieldName; }
    
    public String getFieldValue() { return fieldValue; }
    public void setFieldValue(String fieldValue) { this.fieldValue = fieldValue; }
}