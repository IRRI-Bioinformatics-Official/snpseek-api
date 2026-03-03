package org.irri.snpseek.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class FeatureDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal featureId;
    private String name;
    private String uniquename;
    private BigDecimal seqlen;
    private BigDecimal organismId;
    private BigDecimal typeId;
    private String md5checksum;
    private Boolean isObsolete;

    public FeatureDTO() {
    }

    public FeatureDTO(BigDecimal featureId, String name, String uniquename, BigDecimal seqlen,
                      BigDecimal organismId, BigDecimal typeId, String md5checksum, Boolean isObsolete) {
        this.featureId = featureId;
        this.name = name;
        this.uniquename = uniquename;
        this.seqlen = seqlen;
        this.organismId = organismId;
        this.typeId = typeId;
        this.md5checksum = md5checksum;
        this.isObsolete = isObsolete;
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

    public BigDecimal getTypeId() {
        return typeId;
    }

    public void setTypeId(BigDecimal typeId) {
        this.typeId = typeId;
    }

    public String getMd5checksum() {
        return md5checksum;
    }

    public void setMd5checksum(String md5checksum) {
        this.md5checksum = md5checksum;
    }

    public Boolean getIsObsolete() {
        return isObsolete;
    }

    public void setIsObsolete(Boolean isObsolete) {
        this.isObsolete = isObsolete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FeatureDTO)) return false;
        FeatureDTO that = (FeatureDTO) o;
        return Objects.equals(featureId, that.featureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featureId);
    }

    @Override
    public String toString() {
        return "FeatureDTO{" +
                "featureId=" + featureId +
                ", name='" + name + "'" +
                ", uniquename='" + uniquename + "'" +
                ", seqlen=" + seqlen +
                ", organismId=" + organismId +
                ", typeId=" + typeId +
                ", md5checksum='" + md5checksum + "'" +
                ", isObsolete=" + isObsolete +
                '}';
    }
}