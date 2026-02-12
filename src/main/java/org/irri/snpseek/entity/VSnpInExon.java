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
@NamedQueries({ @NamedQuery(name = "findAllVSnpInExons", query = "select myVSnpInExon from VSnpInExon myVSnpInExon"),
		@NamedQuery(name = "findVSnpInExonByPrimaryKey", query = "select myVSnpInExon from VSnpInExon myVSnpInExon where myVSnpInExon.snpFeatureId = ?1"),
		@NamedQuery(name = "findVSnpInExonBySnpFeatureIdIn", query = "select myVSnpInExon from VSnpInExon myVSnpInExon where myVSnpInExon.snpFeatureId in (?1)"),
		@NamedQuery(name = "findVSnpInExonBySnpFeatureIdBetween", query = "select myVSnpInExon from VSnpInExon myVSnpInExon where myVSnpInExon.snpFeatureId between ?1 and ?2"),
		@NamedQuery(name = "findVSnpInExonBySnpFeatureId", query = "select myVSnpInExon from VSnpInExon myVSnpInExon where myVSnpInExon.snpFeatureId = ?1") })
@Table(name = "V_SNP_IN_EXON")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "iric_prod_crud/org/irri/iric/portal/chado/domain", name = "VSnpInExon")
public class VSnpInExon implements Serializable, Comparable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "SNP_FEATURE_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	BigDecimal snpFeatureId;

	/**
	 */
	public void setSnpFeatureId(BigDecimal snpFeatureId) {
		this.snpFeatureId = snpFeatureId;
	}

	/**
	 */
	public BigDecimal getSnpFeatureId() {
		return this.snpFeatureId;
	}

	/**
	 */
	public VSnpInExon() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(VSnpInExon that) {
		setSnpFeatureId(that.getSnpFeatureId());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("snpFeatureId=[").append(snpFeatureId).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((snpFeatureId == null) ? 0 : snpFeatureId.hashCode()));
		return result;
	}

	/**
	 */
	/*
	 * public boolean equals(Object obj) { if (obj == this) return true; if (!(obj
	 * instanceof VSnpInExon)) return false; VSnpInExon equalCheck = (VSnpInExon)
	 * obj; if ((snpFeatureId == null && equalCheck.snpFeatureId != null) ||
	 * (snpFeatureId != null && equalCheck.snpFeatureId == null)) return false; if
	 * (snpFeatureId != null && !snpFeatureId.equals(equalCheck.snpFeatureId))
	 * return false; return true; }
	 */

	@Override
	public int compareTo(Object o) {

		return this.getSnpFeatureId().compareTo(((VSnpInExon) o).getSnpFeatureId());

	}

	@Override
	public boolean equals(Object obj) {

		return compareTo(obj) == 0;
	}

}
