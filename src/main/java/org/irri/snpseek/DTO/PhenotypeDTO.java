package org.irri.snpseek.DTO;

public class PhenotypeDTO {
    private String phenId;
    private String name;
    private String description;
    
    public PhenotypeDTO() {}
    
    // Getters and Setters
    public String getPhenId() { return phenId; }
    public void setPhenId(String phenId) { this.phenId = phenId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}