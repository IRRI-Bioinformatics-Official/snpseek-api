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
		@NamedQuery(name = "findAllVCvPassports", query = "select myVCvPassport from VCvPassport myVCvPassport order by myVCvPassport.definition"),
		@NamedQuery(name = "findVCvPassportByCvTermId", query = "select myVCvPassport from VCvPassport myVCvPassport where myVCvPassport.cvTermId = ?1"),
		@NamedQuery(name = "findVCvPassportByDefinition", query = "select myVCvPassport from VCvPassport myVCvPassport where myVCvPassport.definition = ?1"),
		@NamedQuery(name = "findVCvPassportByDefinitionContaining", query = "select myVCvPassport from VCvPassport myVCvPassport where myVCvPassport.definition like ?1"),
		@NamedQuery(name = "findVCvPassportByName", query = "select myVCvPassport from VCvPassport myVCvPassport where myVCvPassport.name = ?1"),
		@NamedQuery(name = "findVCvPassportByNameContaining", query = "select myVCvPassport from VCvPassport myVCvPassport where myVCvPassport.name like ?1"),
		@NamedQuery(name = "findVCvPassportByPrimaryKey", query = "select myVCvPassport from VCvPassport myVCvPassport where myVCvPassport.cvTermId = ?1") })
@Table( name = "V_CV_PASSPORT")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "iric_prod_crud/org/irri/iric/portal/chado/domain", name = "VCvPassport")
public class VCvPassport implements Serializable{
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
	public VCvPassport() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(VCvPassport that) {
		setCvTermId(that.getCvTermId());
		setName(that.getName());
		setDefinition(that.getDefinition());
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

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((cvTermId == null) ? 0 : cvTermId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof VCvPassport))
			return false;
		VCvPassport equalCheck = (VCvPassport) obj;
		if ((cvTermId == null && equalCheck.cvTermId != null) || (cvTermId != null && equalCheck.cvTermId == null))
			return false;
		if (cvTermId != null && !cvTermId.equals(equalCheck.cvTermId))
			return false;
		return true;
	}

	public String getAccession() {
		return null;
	}
	
	
}
