package org.irri.snpseek.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ReferenceSequenceDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal featureId;
    private String name;
    private String uniquename;
    private BigDecimal seqlen;
    private BigDecimal organismId;
    private String commonName;
    private BigDecimal typeId;
    private String type;

    public ReferenceSequenceDTO() {
    }

    public ReferenceSequenceDTO(BigDecimal featureId, String name, String uniquename, BigDecimal seqlen,
                                BigDecimal organismId, String commonName, BigDecimal typeId, String type) {
        this.featureId = featureId;
        this.name = name;
        this.uniquename = uniquename;
        this.seqlen = seqlen;
        this.organismId = organismId;
        this.commonName = commonName;
        this.typeId = typeId;
        this.type = type;
    }

    public BigDecimal getFeatureId() {
        return featureId;
    }

    public void setFeatureId(BigDecimal featureId) {
        this.featureId = featureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniquename() {
        return uniquename;
    }

    public void setUniquename(String uniquename) {
        this.uniquename = uniquename;
    }

    public BigDecimal getSeqlen() {
        return seqlen;
    }

    public void setSeqlen(BigDecimal seqlen) {
        this.seqlen = seqlen;
    }

    public BigDecimal getOrganismId() {
        return organismId;
    }

    public void setOrganismId(BigDecimal organismId) {
        this.organismId = organismId;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public BigDecimal getTypeId() {
        return typeId;
    }

    public void setTypeId(BigDecimal typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReferenceSequenceDTO that = (ReferenceSequenceDTO) o;
        return Objects.equals(featureId, that.featureId) &&
                Objects.equals(uniquename, that.uniquename) &&
                Objects.equals(organismId, that.organismId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featureId, uniquename, organismId);
    }

    @Override
    public String toString() {
        return "ReferenceSequenceDTO{" +
                "featureId=" + featureId +
                ", name='" + name + '\'' +
                ", uniquename='" + uniquename + '\'' +
                ", seqlen=" + seqlen +
                ", organismId=" + organismId +
                ", commonName='" + commonName + '\'' +
                ", typeId=" + typeId +
                ", type='" + type + '\'' +
                '}';
    }
}