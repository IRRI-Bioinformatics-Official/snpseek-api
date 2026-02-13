package org.irri.snpseek.DTO;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

public class GenotypeRunDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer genotypeRunId;
    private Calendar datePerformed;
    private String dataLocation;
    private Integer platformId;
    private Integer variantsetId;
    private String variantset;
    private String vsDescription;
    private Integer variantTypeId;
    private Integer datasetId;
    private String dataset;
    private String commonName;
    private String dsDescription;
    private String method;
    private String variantType;

    public GenotypeRunDTO() {}

    // Getters and setters
    public Integer getGenotypeRunId() {
        return genotypeRunId;
    }

    public void setGenotypeRunId(Integer genotypeRunId) {
        this.genotypeRunId = genotypeRunId;
    }

    public Calendar getDatePerformed() {
        return datePerformed;
    }

    public void setDatePerformed(Calendar datePerformed) {
        this.datePerformed = datePerformed;
    }

    public String getDataLocation() {
        return dataLocation;
    }

    public void setDataLocation(String dataLocation) {
        this.dataLocation = dataLocation;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public Integer getVariantsetId() {
        return variantsetId;
    }

    public void setVariantsetId(Integer variantsetId) {
        this.variantsetId = variantsetId;
    }

    public String getVariantset() {
        return variantset;
    }

    public void setVariantset(String variantset) {
        this.variantset = variantset;
    }

    public String getVsDescription() {
        return vsDescription;
    }

    public void setVsDescription(String vsDescription) {
        this.vsDescription = vsDescription;
    }

    public Integer getVariantTypeId() {
        return variantTypeId;
    }

    public void setVariantTypeId(Integer variantTypeId) {
        this.variantTypeId = variantTypeId;
    }

    public Integer getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Integer datasetId) {
        this.datasetId = datasetId;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getDsDescription() {
        return dsDescription;
    }

    public void setDsDescription(String dsDescription) {
        this.dsDescription = dsDescription;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getVariantType() {
        return variantType;
    }

    public void setVariantType(String variantType) {
        this.variantType = variantType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenotypeRunDTO that = (GenotypeRunDTO) o;
        return Objects.equals(genotypeRunId, that.genotypeRunId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genotypeRunId);
    }

    @Override
    public String toString() {
        return "GenotypeRunDTO{" +
                "genotypeRunId=" + genotypeRunId +
                ", datePerformed=" + datePerformed +
                ", dataLocation='" + dataLocation + '\'' +
                ", platformId=" + platformId +
                ", variantsetId=" + variantsetId +
                ", variantset='" + variantset + '\'' +
                ", variantType='" + variantType + '\'' +
                '}';
    }
}
