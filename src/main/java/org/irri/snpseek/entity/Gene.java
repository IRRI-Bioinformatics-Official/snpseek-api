package org.irri.snpseek.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "genes")
public class Gene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String geneId;
    private String contig;
    private Long startPos;
    private Long endPos;
    private String model;
    
    public Gene() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getGeneId() { return geneId; }
    public void setGeneId(String geneId) { this.geneId = geneId; }
    
    public String getContig() { return contig; }
    public void setContig(String contig) { this.contig = contig; }
    
    public Long getStartPos() { return startPos; }
    public void setStartPos(Long startPos) { this.startPos = startPos; }
    
    public Long getEndPos() { return endPos; }
    public void setEndPos(Long endPos) { this.endPos = endPos; }
    
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
}
