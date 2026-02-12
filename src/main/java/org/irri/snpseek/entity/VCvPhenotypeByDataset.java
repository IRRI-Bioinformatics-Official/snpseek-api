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
		@NamedQuery(name = "findAllVCvPhenotypesDataset", query = "select myVCvPhenotype from VCvPhenotypeByDataset myVCvPhenotype order by myVCvPhenotype.definition"),
		@NamedQuery(name = "findAllVCvPhenotypesDatasetByDataset", query = "select myVCvPhenotype from VCvPhenotypeByDataset myVCvPhenotype where  myVCvPhenotype.dataset=?1 order by myVCvPhenotype.definition"),
		@NamedQuery(name = "findVCvPhenotypeByCvTermIdDataset", query = "select myVCvPhenotype from VCvPhenotypeByDataset myVCvPhenotype where myVCvPhenotype.cvTermId = ?1 and myVCvPhenotype.dataset=?2"),
		@NamedQuery(name = "findVCvPhenotypeByDefinitionDataset", query = "select myVCvPhenotype from VCvPhenotypeByDataset myVCvPhenotype where myVCvPhenotype.definition = ?1 and myVCvPhenotype.dataset=?2"),
		@NamedQuery(name = "findVCvPhenotypeByDefinitionContainingDataset", query = "select myVCvPhenotype from VCvPhenotypeByDataset myVCvPhenotype where myVCvPhenotype.definition like ?1 and myVCvPhenotype.dataset=?2"),
		@NamedQuery(name = "findVCvPhenotypeByNameDataset", query = "select myVCvPhenotype from VCvPhenotypeByDataset myVCvPhenotype where myVCvPhenotype.name = ?1 and myVCvPhenotype.dataset=?2"),
		@NamedQuery(name = "findVCvPhenotypeByNameContainingDataset", query = "select myVCvPhenotype from VCvPhenotypeByDataset myVCvPhenotype where myVCvPhenotype.name like ?1 and myVCvPhenotype.dataset=?2"),
		@NamedQuery(name = "findVCvPhenotypeByPrimaryKeyDataset", query = "select myVCvPhenotype from VCvPhenotypeByDataset myVCvPhenotype where myVCvPhenotype.cvTermId = ?1 and myVCvPhenotype.dataset=?2") })
@Table(name = "V_CV_PHENOTYPE_ALLSTOCKS")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "iric_prod_crud/org/irri/iric/portal/chado/domain", name = "VCvPhenotypeByDataset")
public class VCvPhenotypeByDataset implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "CVTERM_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	BigDecimal cvTermId;
	/**
	 */

	@Column(name = "NAME", length = 1024)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 */

	@Column(name = "DEFINITION", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String definition;

	@Column(name = "DATASET", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	String dataset;

	/**
	 */
	public void setCvTermId(BigDecimal cvTermId) {
		this.cvTermId = cvTermId;
	}

	/**
	 */
	public BigDecimal getCvTermId() {
		return this.cvTermId;
	}

	/**
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 */
	public String getName() {
		return this.name;
	}

	/**
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}

	/**
	 */
	public String getDefinition() {
		return this.definition;
	}

	/**
	 */
	public VCvPhenotypeByDataset() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(VCvPhenotypeByDataset that) {
		setCvTermId(that.getCvTermId());
		setName(that.getName());
		setDefinition(that.getDefinition());
		setDataset(that.getDataset());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cvTermId=[").append(cvTermId).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("definition=[").append(definition).append("] ");
		buffer.append("dataset=[").append(dataset).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((cvTermId == null) ? 0 : cvTermId.hashCode()));
		result = (int) (prime * result + ((dataset == null) ? 0 : dataset.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof VCvPhenotypeByDataset))
			return false;
		VCvPhenotypeByDataset equalCheck = (VCvPhenotypeByDataset) obj;
		if ((cvTermId == null && equalCheck.cvTermId != null) || (cvTermId != null && equalCheck.cvTermId == null))
			return false;
		if (cvTermId != null && !cvTermId.equals(equalCheck.cvTermId))
			return false;
		if ((dataset == null && equalCheck.dataset != null) || (dataset != null && equalCheck.dataset == null))
			return false;
		if (dataset != null && !dataset.equals(equalCheck.dataset))
			return false;
		return true;
	}

	public String getAccession() {
		return null;
	}

	public String getDataset() {
		
		return this.dataset;
	}

	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

}
