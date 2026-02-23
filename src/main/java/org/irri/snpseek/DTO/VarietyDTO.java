package org.irri.snpseek.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for variety/germplasm
 * 
 *  From VAllstockBasicprop view
 * 
 * @author LMansueto
 */
public class VarietyDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal stockSampleId;
	private BigDecimal allStockIdId;
	private String name;
	private String irisUniqueId;
	private String oriCountry;
	private String subpopulation;
	private String boxCode;
	private String gsAccession;
	private String dataset;

	public VarietyDTO() {
	}

	// getters and setters
	public BigDecimal getStockSampleId() {
		return stockSampleId;
	}

	public void setStockSampleId(BigDecimal stockSampleId) {
		this.stockSampleId = stockSampleId;
	}

	public BigDecimal getAllStockIdId() {
		return allStockIdId;
	}

	public void setAllStockIdId(BigDecimal allStockIdId) {
		this.allStockIdId = allStockIdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIrisUniqueId() {
		return irisUniqueId;
	}

	public void setIrisUniqueId(String irisUniqueId) {
		this.irisUniqueId = irisUniqueId;
	}

	public String getOriCountry() {
		return oriCountry;
	}

	public void setOriCountry(String oriCountry) {
		this.oriCountry = oriCountry;
	}

	public String getSubpopulation() {
		return subpopulation;
	}

	public void setSubpopulation(String subpopulation) {
		this.subpopulation = subpopulation;
	}

	public String getBoxCode() {
		return boxCode;
	}

	public void setBoxCode(String boxCode) {
		this.boxCode = boxCode;
	}

	public String getGsAccession() {
		return gsAccession;
	}

	public void setGsAccession(String gsAccession) {
		this.gsAccession = gsAccession;
	}

	public String getDataset() {
		return dataset;
	}

	public void setDataset(String dataset) {
		this.dataset = dataset;
	}
}
