package org.irri.snpseek.DTO;

public class GenotypeRequest {
    private String varid;
    private String chr;
    private Long start;
    private Long end;
    private Boolean snp;
    private Boolean indel;
    private Boolean coreonly;
    private Boolean mismatchonly;
    private String poslist;
    private String subpopulation;
    private String locus;
    private Boolean alignindels;
    
    public GenotypeRequest() {}
    
    // Getters and Setters
    public String getVarid() { return varid; }
    public void setVarid(String varid) { this.varid = varid; }
    
    public String getChr() { return chr; }
    public void setChr(String chr) { this.chr = chr; }
    
    public Long getStart() { return start; }
    public void setStart(Long start) { this.start = start; }
    
    public Long getEnd() { return end; }
    public void setEnd(Long end) { this.end = end; }
    
    public Boolean getSnp() { return snp; }
    public void setSnp(Boolean snp) { this.snp = snp; }
    
    public Boolean getIndel() { return indel; }
    public void setIndel(Boolean indel) { this.indel = indel; }
    
    public Boolean getCoreonly() { return coreonly; }
    public void setCoreonly(Boolean coreonly) { this.coreonly = coreonly; }
    
    public Boolean getMismatchonly() { return mismatchonly; }
    public void setMismatchonly(Boolean mismatchonly) { this.mismatchonly = mismatchonly; }
    
    public String getPoslist() { return poslist; }
    public void setPoslist(String poslist) { this.poslist = poslist; }
    
    public String getSubpopulation() { return subpopulation; }
    public void setSubpopulation(String subpopulation) { this.subpopulation = subpopulation; }
    
    public String getLocus() { return locus; }
    public void setLocus(String locus) { this.locus = locus; }
    
    public Boolean getAlignindels() { return alignindels; }
    public void setAlignindels(Boolean alignindels) { this.alignindels = alignindels; }
}