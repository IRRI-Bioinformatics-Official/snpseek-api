package org.irri.snpseek.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "v_variety")
public class Variety {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variety_id")
    private BigDecimal varietyId;
    
    @Column(name = "stock_sample_id")
    private BigDecimal stockSampleId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "iris_id")
    private String irisId;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "subpopulation")
    private String subpopulation;
    
    @Column(name = "accession")
    private String accession;
    
    @Column(name = "box_code")
    private String boxCode;
    
    @Column(name = "dataset")
    private String dataset;
    
    // Constructors
    public Variety() {
    }
    
    public Variety(BigDecimal varietyId, String name, String country) {
        this.varietyId = varietyId;
        this.name = name;
        this.country = country;
    }
    
    // Getters
    /**
     * Variety Id
     *
     * @return
     */
    public BigDecimal getVarietyId() {
        return varietyId;
    }

    /**
     * Stock Sample Id
     *
     * @return
     */
    public BigDecimal getStockSampleId() {
        return stockSampleId;
    }

    /**
     * Variety name from source
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * IRIS Unique ID
     *
     * @return
     */
    public String getIrisId() {
        return irisId;
    }

    /**
     * Country of origin
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     * Subpopulation (indica, japonica, aus, etc.)
     *
     * @return
     */
    public String getSubpopulation() {
        return subpopulation;
    }

    /**
     * Accession, from whatever source
     *
     * @return
     */
    public String getAccession() {
        return accession;
    }

    /**
     * Box code
     *
     * @return
     */
    public String getBoxCode() {
        return boxCode;
    }

    /**
     * Dataset, defined in VarietyFacade.DATASET_*
     *
     * @return
     */
    public String getDataset() {
        return dataset;
    }

    // Setters
    public void setVarietyId(BigDecimal varietyId) {
        this.varietyId = varietyId;
    }

    public void setStockSampleId(BigDecimal stockSampleId) {
        this.stockSampleId = stockSampleId;
    }

    /**
     * Used for query by example
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setIrisId(String irisId) {
        this.irisId = irisId;
    }

    /**
     * Used for query by example
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Used for query by example
     *
     * @param subpopulation
     */
    public void setSubpopulation(String subpopulation) {
        this.subpopulation = subpopulation;
    }

    /**
     * Used for query by example
     *
     * @param accession
     */
    public void setAccession(String accession) {
        this.accession = accession;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    // Utility methods
    /**
     * Print fields using delimiter
     *
     * @param delimiter
     * @return
     */
    public String printFields(String delimiter) {
        StringBuilder sb = new StringBuilder();
        sb.append(varietyId).append(delimiter)
          .append(stockSampleId).append(delimiter)
          .append(name).append(delimiter)
          .append(irisId).append(delimiter)
          .append(country).append(delimiter)
          .append(subpopulation).append(delimiter)
          .append(accession).append(delimiter)
          .append(boxCode).append(delimiter)
          .append(dataset);
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return "Variety{" +
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variety variety = (Variety) o;
        return varietyId != null && varietyId.equals(variety.varietyId);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}