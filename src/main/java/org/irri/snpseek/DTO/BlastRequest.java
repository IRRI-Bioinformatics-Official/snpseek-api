package org.irri.snpseek.DTO;

public class BlastRequest {
    private String sequence;
    private String program;
    private String db;
    private Double maxe;
    
    public BlastRequest() {}
    
    // Getters and Setters
    public String getSequence() { return sequence; }
    public void setSequence(String sequence) { this.sequence = sequence; }
    
    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }
    
    public String getDb() { return db; }
    public void setDb(String db) { this.db = db; }
    
    public Double getMaxe() { return maxe; }
    public void setMaxe(Double maxe) { this.maxe = maxe; }
}