package org.irri.snpseek.DTO;

import java.math.BigDecimal;
import java.util.Objects;

public class VarietyDTO implements Comparable<VarietyDTO> {

    private BigDecimal varietyId;
    private BigDecimal stockSampleId;
    private String name;
    private String irisId;
    private String country;
    private String subpopulation;
    private String accession;
    private String boxCode;
    private String dataset;

    public VarietyDTO() {
    }

    public VarietyDTO(BigDecimal varietyId, BigDecimal stockSampleId, String name, String irisId,
                      String country, String subpopulation, String accession, String boxCode, String dataset) {
        this.varietyId = varietyId;
        this.stockSampleId = stockSampleId;
        this.name = name;
        this.irisId = irisId;
        this.country = country;
        this.subpopulation = subpopulation;
        this.accession = accession;
        this.boxCode = boxCode;
        this.dataset = dataset;
    }

    public BigDecimal getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(BigDecimal varietyId) {
        this.varietyId = varietyId;
    }

    public BigDecimal getStockSampleId() {
        return stockSampleId;
    }

    public void setStockSampleId(BigDecimal stockSampleId) {
        this.stockSampleId = stockSampleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIrisId() {
        return irisId;
    }

    public void setIrisId(String irisId) {
        this.irisId = irisId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSubpopulation() {
        return subpopulation;
    }

    public void setSubpopulation(String subpopulation) {
        this.subpopulation = subpopulation;
    }

    public String getAccession() {
        return accession;
    }

    public void setAccession(String accession) {
        this.accession = accession;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    /**
     * Utility to print fields separated by the provided delimiter.
     */
    public String printFields(String delimiter) {
        StringBuilder sb = new StringBuilder();
        sb.append(varietyId != null ? varietyId.toString() : "")
          .append(delimiter).append(stockSampleId != null ? stockSampleId.toString() : "")
          .append(delimiter).append(name != null ? name : "")
          .append(delimiter).append(irisId != null ? irisId : "")
          .append(delimiter).append(country != null ? country : "")
          .append(delimiter).append(subpopulation != null ? subpopulation : "")
          .append(delimiter).append(accession != null ? accession : "")
          .append(delimiter).append(boxCode != null ? boxCode : "")
          .append(delimiter).append(dataset != null ? dataset : "");
        return sb.toString();
    }

    @Override
    public int compareTo(VarietyDTO o) {
        if (this.varietyId != null && o.varietyId != null) {
            int cmp = this.varietyId.compareTo(o.varietyId);
            if (cmp != 0) return cmp;
        } else if (this.varietyId == null && o.varietyId != null) {
            return -1;
        } else if (this.varietyId != null && o.varietyId == null) {
            return 1;
        }
        // fallback to name
        if (this.name == null && o.name == null) return 0;
        if (this.name == null) return -1;
        if (o.name == null) return 1;
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VarietyDTO)) return false;
        VarietyDTO other = (VarietyDTO) o;
        return Objects.equals(varietyId, other.varietyId) &&
               Objects.equals(stockSampleId, other.stockSampleId) &&
               Objects.equals(name, other.name) &&
               Objects.equals(irisId, other.irisId) &&
               Objects.equals(country, other.country) &&
               Objects.equals(subpopulation, other.subpopulation) &&
               Objects.equals(accession, other.accession) &&
               Objects.equals(boxCode, other.boxCode) &&
               Objects.equals(dataset, other.dataset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(varietyId, stockSampleId, name, irisId, country, subpopulation, accession, boxCode, dataset);
    }

    @Override
    public String toString() {
        return "VarietyDTO{" +
                "varietyId=" + varietyId +
                ", stockSampleId=" + stockSampleId +
                ", name='" + name + '\'' +
                ", irisId='" + irisId + '\'' +
                ", country='" + country + '\'' +
                ", subpopulation='" + subpopulation + '\'' +
                ", accession='" + accession + '\'' +
                ", boxCode='" + boxCode + '\'' +
                ", dataset='" + dataset + '\'' +
                '}';
    }
}