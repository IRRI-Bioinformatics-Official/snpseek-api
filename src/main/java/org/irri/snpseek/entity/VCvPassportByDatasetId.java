package org.irri.snpseek.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class VCvPassportByDatasetId implements Serializable {
    private static final long serialVersionUID = 1L;

    public BigDecimal cvTermId;
    public String dataset;

    public VCvPassportByDatasetId() {}

    public VCvPassportByDatasetId(BigDecimal cvTermId, String dataset) {
        this.cvTermId = cvTermId;
        this.dataset = dataset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VCvPassportByDatasetId that = (VCvPassportByDatasetId) o;
        if (cvTermId != null ? !cvTermId.equals(that.cvTermId) : that.cvTermId != null) return false;
        return dataset != null ? dataset.equals(that.dataset) : that.dataset == null;
    }

    @Override
    public int hashCode() {
        int result = cvTermId != null ? cvTermId.hashCode() : 0;
        result = 31 * result + (dataset != null ? dataset.hashCode() : 0);
        return result;
    }
}
