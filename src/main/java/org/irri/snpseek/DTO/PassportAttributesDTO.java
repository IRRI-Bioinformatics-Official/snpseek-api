package org.irri.snpseek.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class PassportAttributesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal cvTermId;
    private String name;
    private String definition;
    private String dataset;

    public PassportAttributesDTO() {}

    public PassportAttributesDTO(BigDecimal cvTermId, String name, String definition, String dataset) {
        this.cvTermId = cvTermId;
        this.name = name;
        this.definition = definition;
        this.dataset = dataset;
    }

    public BigDecimal getCvTermId() {
        return cvTermId;
    }

    public void setCvTermId(BigDecimal cvTermId) {
        this.cvTermId = cvTermId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }
}
