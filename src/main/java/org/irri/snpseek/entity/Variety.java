package org.irri.snpseek.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "varieties")
public class Variety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String subpopulation;
    private String country;
    
    public Variety() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getSubpopulation() { return subpopulation; }
    public void setSubpopulation(String subpopulation) { this.subpopulation = subpopulation; }
    
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}