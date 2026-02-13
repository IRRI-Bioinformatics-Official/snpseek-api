package org.irri.snpseek.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.irri.snpseek.variety.domain.object.VIricstockPassportValuesPK;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;



/**
 */
//@IdClass(VIricstockPassportValuesPK.class)
@Entity
@NamedQueries({
		@NamedQuery(name = "findAllVIricstockPassportValuess", query = "select myVIricstockPassportValues from VIricstockPassportValues myVIricstockPassportValues"),
		@NamedQuery(name = "findVIricstockPassportValuesByPrimaryKey", query = "select myVIricstockPassportValues from VIricstockPassportValues myVIricstockPassportValues where myVIricstockPassportValues.value = ?1 and myVIricstockPassportValues.typeId = ?2"),
		@NamedQuery(name = "findVIricstockPassportValuesByTypeId", query = "select myVIricstockPassportValues from VIricstockPassportValues myVIricstockPassportValues where myVIricstockPassportValues.typeId = ?1 and myVIricstockPassportValues.dataset in (?2)"),

		@NamedQuery(name = "findVIricstockPassportValuesByValue", query = "select myVIricstockPassportValues from VIricstockPassportValues myVIricstockPassportValues where myVIricstockPassportValues.value = ?1 and myVIricstockPassportValues.dataset in (?2)"),
		@NamedQuery(name = "findVIricstockPassportValuesByValueContaining", query = "select myVIricstockPassportValues from VIricstockPassportValues myVIricstockPassportValues where myVIricstockPassportValues.value like ?1 and myVIricstockPassportValues.dataset in ( ?2)") })

// @Table( name = "V_IRICSTOCK_PASSPORT_VALUES")
@Table(name = "V_STOCK_PASSPORT_VALUES")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "iric_prod_crud/org/irri/iric/portal/chado/domain", name = "VIricstockPassportValues")
public class VIricstockPassportValues implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "VALUE", length = 4000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	String value;
	/**
	 */

	@Column(name = "TYPE_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	BigDecimal typeId;

	@Column(name = "DATASET", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	String dataset;

	/**
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 */
	public void setTypeId(BigDecimal typeId) {
		this.typeId = typeId;
	}

	/**
	 */
	public BigDecimal getTypeId() {
		return this.typeId;
	}

	public String getDataset() {
		return dataset;
	}

	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	/**
	 */
	public VIricstockPassportValues() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(VIricstockPassportValues that) {
		setValue(that.getValue());
		setTypeId(that.getTypeId());
		setDataset(that.getDataset());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("value=[").append(value).append("] ");
		buffer.append("typeId=[").append(typeId).append("] ");
		buffer.append("dataset=[").append(dataset).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((value == null) ? 0 : value.hashCode()));
		result = (int) (prime * result + ((typeId == null) ? 0 : typeId.hashCode()));
		result = (int) (prime * result + ((dataset == null) ? 0 : dataset.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof VIricstockPassportValues))
			return false;
		VIricstockPassportValues equalCheck = (VIricstockPassportValues) obj;
		if ((value == null && equalCheck.value != null) || (value != null && equalCheck.value == null))
			return false;
		if (value != null && !value.equals(equalCheck.value))
			return false;
		if ((typeId == null && equalCheck.typeId != null) || (typeId != null && equalCheck.typeId == null))
			return false;
		if (typeId != null && !typeId.equals(equalCheck.typeId))
			return false;
		if ((dataset == null && equalCheck.dataset != null) || (dataset != null && equalCheck.dataset == null))
			return false;
		if (dataset != null && !dataset.equals(equalCheck.dataset))
			return false;
		return true;
	}
}
