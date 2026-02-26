package org.irri.snpseek.DTO;

import java.io.Serializable;
import java.util.Objects;

public class SnpRefPosIndex implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long snpFeatureId;
	private Integer chromosome;
	private Long position;
	private String refcall;
	private String altcall;
	private Integer alleleIndex;
	private Integer typeId;
	private String variantsetName;

	// No-arg constructor
	public SnpRefPosIndex() {
	}

	// Full-arg constructor
	public SnpRefPosIndex(Long snpFeatureId, Integer chromosome, Long position, String refcall, String altcall, Integer alleleIndex, Integer typeId, String variantsetName) {
		this.snpFeatureId = snpFeatureId;
		this.chromosome = chromosome;
		this.position = position;
		this.refcall = refcall;
		this.altcall = altcall;
		this.alleleIndex = alleleIndex;
		this.typeId = typeId;
		this.variantsetName = variantsetName;
	}

	// Getters and setters
	public Long getSnpFeatureId() {
		return snpFeatureId;
	}

	public void setSnpFeatureId(Long snpFeatureId) {
		this.snpFeatureId = snpFeatureId;
	}

	public Integer getChromosome() {
		return chromosome;
	}

	public void setChromosome(Integer chromosome) {
		this.chromosome = chromosome;
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

	public String getAltcall() {
		return altcall;
	}

	public void setAltcall(String altcall) {
		this.altcall = altcall;
	}

	public Integer getAlleleIndex() {
		return alleleIndex;
	}

	public void setAlleleIndex(Integer alleleIndex) {
		this.alleleIndex = alleleIndex;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getVariantsetName() {
		return variantsetName;
	}

	public void setVariantsetName(String variantsetName) {
		this.variantsetName = variantsetName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SnpRefPosIndex that = (SnpRefPosIndex) o;
		return Objects.equals(snpFeatureId, that.snpFeatureId) &&
			Objects.equals(chromosome, that.chromosome) &&
			Objects.equals(position, that.position) &&
			Objects.equals(refcall, that.refcall) &&
			Objects.equals(altcall, that.altcall) &&
			Objects.equals(alleleIndex, that.alleleIndex) &&
			Objects.equals(typeId, that.typeId) &&
			Objects.equals(variantsetName, that.variantsetName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(snpFeatureId, chromosome, position, refcall, altcall, alleleIndex, typeId, variantsetName);
	}

	@Override
	public String toString() {
		return "SnpRefPosIndex{" +
			"snpFeatureId=" + snpFeatureId +
			", chromosome=" + chromosome +
			", position=" + position +
			", refcall='" + refcall + '\'' +
			", altcall='" + altcall + '\'' +
			", alleleIndex=" + alleleIndex +
			", typeId=" + typeId +
			", variantsetName='" + variantsetName + '\'' +
			'}';
	}
}