package org.irri.snpseek.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "snp_feature")
public class SnpFeature implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "snp_feature_id")
    private Long snpFeatureId;

    @Basic
    @Column(name = "organism_id")
    private Integer organismId;

    @Basic
    @Column(name = "srcfeature_id")
    private Long srcfeatureId;

    @Basic
    @Column(name = "position")
    private Long position;

    @Basic
    @Column(name = "refcall")
    private String refcall;

    public SnpFeature() {
    }

    public SnpFeature(Long snpFeatureId, Integer organismId, Long srcfeatureId, Long position, String refcall) {
        this.snpFeatureId = snpFeatureId;
        this.organismId = organismId;
        this.srcfeatureId = srcfeatureId;
        this.position = position;
        this.refcall = refcall;
    }

    public Long getSnpFeatureId() {
        return snpFeatureId;
    }

    public void setSnpFeatureId(Long snpFeatureId) {
        this.snpFeatureId = snpFeatureId;
    }

    public Integer getOrganismId() {
        return organismId;
    }

    public void setOrganismId(Integer organismId) {
        this.organismId = organismId;
    }

    public Long getSrcfeatureId() {
        return srcfeatureId;
    }

    public void setSrcfeatureId(Long srcfeatureId) {
        this.srcfeatureId = srcfeatureId;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String getRefcall() {
        return refcall;
    }

    public void setRefcall(String refcall) {
        this.refcall = refcall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnpFeature that = (SnpFeature) o;
        return Objects.equals(snpFeatureId, that.snpFeatureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snpFeatureId);
    }

    @Override
    public String toString() {
        return "SnpFeature{" +
                "snpFeatureId=" + snpFeatureId +
                ", organismId=" + organismId +
                ", srcfeatureId=" + srcfeatureId +
                ", position=" + position +
                ", refcall='" + refcall + '\'' +
                '}';
    }
}
