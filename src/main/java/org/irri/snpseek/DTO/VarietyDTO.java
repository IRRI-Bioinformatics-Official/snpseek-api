package org.irri.snpseek.DTO;

import java.math.BigDecimal;

public class VarietyDTO {
	private BigDecimal id;
	private String name;
	private String subpopulation;
	private String country;

	public VarietyDTO() {
	}

	// Getters and Setters
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubpopulation() {
		return subpopulation;
	}

	public void setSubpopulation(String subpopulation) {
		this.subpopulation = subpopulation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}