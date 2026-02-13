package org.irri.snpseek.DTO;

import java.math.BigDecimal;

public class OrganismDTO {
	private BigDecimal id;
	private String name;
	
	public OrganismDTO() {
	}

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
}