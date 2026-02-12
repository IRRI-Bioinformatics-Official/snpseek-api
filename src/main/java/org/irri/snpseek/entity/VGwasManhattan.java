package org.irri.snpseek.entity;

import java.io.Serializable;
import java.math.BigDecimal;


import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllVGwasManhattans", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan"),
		@NamedQuery(name = "findVGwasManhattanByChromosome", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan where myVGwasManhattan.chromosome = ?1"),
		@NamedQuery(name = "findVGwasManhattanByGwasMarkerId", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan where myVGwasManhattan.gwasMarkerId = ?1"),
		@NamedQuery(name = "findVGwasManhattanByMinusLogp", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan where myVGwasManhattan.minusLogp = ?1"),
		@NamedQuery(name = "findVGwasManhattanByPosition", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan where myVGwasManhattan.position = ?1"),
		@NamedQuery(name = "findVGwasManhattanByPrimaryKey", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan where myVGwasManhattan.gwasMarkerId = ?1"),
		@NamedQuery(name = "findVGwasManhattanBySubpopulation", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan where myVGwasManhattan.subpopulation = ?1"),
		@NamedQuery(name = "findVGwasManhattanBySubpopulationContaining", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan where myVGwasManhattan.subpopulation like ?1"),
		@NamedQuery(name = "findVGwasManhattanBySubpopulationId", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan where myVGwasManhattan.subpopulationId = ?1"),
		@NamedQuery(name = "findVGwasManhattanByGwasRunId", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan where myVGwasManhattan.gwasRunId = ?1"),
		@NamedQuery(name = "findVGwasManhattanByTrait", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan where myVGwasManhattan.trait = ?1"),
		@NamedQuery(name = "findVGwasManhattanByTraitContaining", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan where myVGwasManhattan.trait like ?1"),
		@NamedQuery(name = "findVGwasManhattanByTraitId", query = "select myVGwasManhattan from VGwasManhattan myVGwasManhattan where myVGwasManhattan.traitId = ?1") })
@Table(name = "V_GWAS_MANHATTAN")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "iric_prod_crud/org/irri/iric/portal/chado/oracle/domain", name = "VGwasManhattan")
public class VGwasManhattan implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "GWAS_MARKER_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	BigDecimal gwasMarkerId;
	/**
	 */

	@Column(name = "MINUS_LOGP", scale = 5, precision = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal minusLogp;
	/**
	 */

	@Column(name = "CHROMOSOME")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Long chromosome;
	/**
	 */

	@Column(name = "POSITION")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal position;
	/**
	 */

	@Column(name = "TRAIT", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String trait;
	/**
	 */

	@Column(name = "TRAIT_ID", precision = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal traitId;
	/**
	 */

	@Column(name = "SUBPOPULATION", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String subpopulation;
	/**
	 */

	@Column(name = "SUBPOPULATION_ID", precision = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal subpopulationId;

	@Column(name = "GWAS_RUN_ID", precision = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal gwasRunId;

	/**
	 */
	public void setGwasMarkerId(BigDecimal gwasMarkerId) {
		this.gwasMarkerId = gwasMarkerId;
	}

	/**
	 */
	public BigDecimal getGwasMarkerId() {
		return this.gwasMarkerId;
	}

	/**
	 */
	public void setMinusLogp(BigDecimal minusLogp) {
		this.minusLogp = minusLogp;
	}

	/**
	 */
	public BigDecimal getMinusLogp() {
		return this.minusLogp;
	}

	/**
	 */
	public void setChromosome(Long chromosome) {
		this.chromosome = chromosome;
	}

	/**
	 */
	public Long getChromosome() {
		return this.chromosome;
	}

	/**
	 */
	public void setPosition(BigDecimal position) {
		this.position = position;
	}

	/**
	 */
	public BigDecimal getPosition() {
		return this.position;
	}

	/**
	 */
	public void setTrait(String trait) {
		this.trait = trait;
	}

	/**
	 */
	public String getTrait() {
		return this.trait;
	}

	/**
	 */
	public void setTraitId(BigDecimal traitId) {
		this.traitId = traitId;
	}

	/**
	 */
	public BigDecimal getTraitId() {
		return this.traitId;
	}

	/**
	 */
	public void setSubpopulation(String subpopulation) {
		this.subpopulation = subpopulation;
	}

	/**
	 */
	public String getSubpopulation() {
		return this.subpopulation;
	}

	/**
	 */
	public void setSubpopulationId(BigDecimal subpopulationId) {
		this.subpopulationId = subpopulationId;
	}

	/**
	 */
	public BigDecimal getSubpopulationId() {
		return this.subpopulationId;
	}

	/**
	 */
	public VGwasManhattan() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(VGwasManhattan that) {
		setGwasMarkerId(that.getGwasMarkerId());
		setMinusLogp(that.getMinusLogp());
		setChromosome(that.getChromosome());
		setPosition(that.getPosition());
		setTrait(that.getTrait());
		setTraitId(that.getTraitId());
		setSubpopulation(that.getSubpopulation());
		setSubpopulationId(that.getSubpopulationId());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("gwasMarkerId=[").append(gwasMarkerId).append("] ");
		buffer.append("minusLogp=[").append(minusLogp).append("] ");
		buffer.append("chromosome=[").append(chromosome).append("] ");
		buffer.append("position=[").append(position).append("] ");
		buffer.append("trait=[").append(trait).append("] ");
		buffer.append("traitId=[").append(traitId).append("] ");
		buffer.append("subpopulation=[").append(subpopulation).append("] ");
		buffer.append("subpopulationId=[").append(subpopulationId).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((gwasMarkerId == null) ? 0 : gwasMarkerId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof VGwasManhattan))
			return false;
		VGwasManhattan equalCheck = (VGwasManhattan) obj;
		if ((gwasMarkerId == null && equalCheck.gwasMarkerId != null)
				|| (gwasMarkerId != null && equalCheck.gwasMarkerId == null))
			return false;
		if (gwasMarkerId != null && !gwasMarkerId.equals(equalCheck.gwasMarkerId))
			return false;
		return true;
	}

	public String getContig() {
		
		if (chromosome > 9)
			return "chr" + chromosome;
		else
			return "chr0" + chromosome;
	}

	public String getRefnuc() {
		return null;
	}

	public Long getChr() {
		
		return chromosome;
	}

//	public int compareTo(Object o) {
//		
//		return this.gwasMarkerId.compareTo(((ManhattanPlot) o).getMarkerId());
//	}

	public BigDecimal getMarkerId() {
		
		return this.gwasMarkerId;
	}

	public Double getMinusLogPvalue() {
		
		return minusLogp.doubleValue();
	}

	public void setMinusLogPvalue(Double pval) {
		
		minusLogp = BigDecimal.valueOf(pval);
	}

}
