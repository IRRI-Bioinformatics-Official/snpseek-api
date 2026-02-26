package org.irri.snpseek.DTO;

import java.math.BigDecimal;

public class VAllsampleBasicpropDTO {
    private BigDecimal stockSampleId;
    private String assay;
    private String dataset;
    private Integer hdf5Index;
    private BigDecimal stockId;
    private String name;
    private String oriCountry;
    private String subpopulation;
    private String boxCode;
    private String gsAccession;

    public VAllsampleBasicpropDTO() {}

    public VAllsampleBasicpropDTO(BigDecimal stockSampleId, String assay, String dataset, Integer hdf5Index, BigDecimal stockId, String name, String oriCountry, String subpopulation, String boxCode, String gsAccession) {
        this.stockSampleId = stockSampleId;
        this.assay = assay;
        this.dataset = dataset;
        this.hdf5Index = hdf5Index;
        this.stockId = stockId;
        this.name = name;
        this.oriCountry = oriCountry;
        this.subpopulation = subpopulation;
        this.boxCode = boxCode;
        this.gsAccession = gsAccession;
    }

    // getters and setters
    public BigDecimal getStockSampleId() { return stockSampleId; }
    public void setStockSampleId(BigDecimal stockSampleId) { this.stockSampleId = stockSampleId; }

    public String getAssay() { return assay; }
    public void setAssay(String assay) { this.assay = assay; }

    public String getDataset() { return dataset; }
    public void setDataset(String dataset) { this.dataset = dataset; }

    public Integer getHdf5Index() { return hdf5Index; }
    public void setHdf5Index(Integer hdf5Index) { this.hdf5Index = hdf5Index; }

    public BigDecimal getStockId() { return stockId; }
    public void setStockId(BigDecimal stockId) { this.stockId = stockId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOriCountry() { return oriCountry; }
    public void setOriCountry(String oriCountry) { this.oriCountry = oriCountry; }

    public String getSubpopulation() { return subpopulation; }
    public void setSubpopulation(String subpopulation) { this.subpopulation = subpopulation; }

    public String getBoxCode() { return boxCode; }
    public void setBoxCode(String boxCode) { this.boxCode = boxCode; }

    public String getGsAccession() { return gsAccession; }
    public void setGsAccession(String gsAccession) { this.gsAccession = gsAccession; }
}
