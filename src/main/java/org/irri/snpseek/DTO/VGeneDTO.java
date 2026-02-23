package org.irri.snpseek.DTO;

public class VGeneDTO {
    private Integer geneId;
    private String name;
    private String chr;
    private Integer fmin;
    private Integer fmax;
    private Integer strand;
    private Integer phase;
    private Integer organismId;

    public VGeneDTO() {
    }

    public Integer getGeneId() {
        return geneId;
    }

    public void setGeneId(Integer geneId) {
        this.geneId = geneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public Integer getFmin() {
        return fmin;
    }

    public void setFmin(Integer fmin) {
        this.fmin = fmin;
    }

    public Integer getFmax() {
        return fmax;
    }

    public void setFmax(Integer fmax) {
        this.fmax = fmax;
    }

    public Integer getStrand() {
        return strand;
    }

    public void setStrand(Integer strand) {
        this.strand = strand;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public Integer getOrganismId() {
        return organismId;
    }

    public void setOrganismId(Integer organismId) {
        this.organismId = organismId;
    }
}
