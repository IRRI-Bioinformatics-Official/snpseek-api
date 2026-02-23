package org.irri.snpseek.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.irri.snpseek.domain.Variety;

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

@Entity
@IdClass(VAllstockBasicpropId.class)
@NamedQueries({
		@NamedQuery(name = "findAllVAllstockBasicprops", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop"),
		@NamedQuery(name = "findVAllstockBasicpropByBoxCode", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.boxCode) = upper(?1)"),
		@NamedQuery(name = "findVAllstockBasicpropByBoxCodeContaining", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.boxCode) like upper(?1)"),
		@NamedQuery(name = "findVAllstockBasicpropByallStockIdId", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where myVAllstockBasicprop.allStockIdId = ?1"),
		@NamedQuery(name = "findVAllstockBasicpropByIrisUniqueId", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.irisUniqueId) = upper(?1)"),
		@NamedQuery(name = "findVAllstockBasicpropByIrisUniqueIdContaining", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.irisUniqueId) like upper(?1)"),
		@NamedQuery(name = "findVAllstockBasicpropByName", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.name) = upper(?1)"),
		@NamedQuery(name = "findVAllstockBasicpropByNameContaining", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.name) like upper(?1)"),
		@NamedQuery(name = "findVAllstockBasicpropByOriCountry", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.oriCountry) = upper(?1)"),
		@NamedQuery(name = "findVAllstockBasicpropByOriCountryContaining", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.oriCountry) like upper(?1)"),
		@NamedQuery(name = "findVAllstockBasicpropByPrimaryKey", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where myVAllstockBasicprop.allStockIdId = ?1"),

		@NamedQuery(name = "findVAllstockBasicpropByPrimaryKeys", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where myVAllstockBasicprop.allStockIdId in (?1)"),
		@NamedQuery(name = "findVAllstockBasicpropByNameGsaccession", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.name) = upper(?1) and  upper(myVAllstockBasicprop.gsAccession) = upper(?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.dataset) = upper(?1)"),

		@NamedQuery(name = "findVAllstockBasicpropByGsaccession", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.gsAccession) = upper(?1)"),
		@NamedQuery(name = "findVAllstockBasicpropBySubpopulation", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.subpopulation) = upper(?1)  order by myVAllstockBasicprop.name"),
		@NamedQuery(name = "findVAllstockBasicpropByOriCountrySubpopulation", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.oriCountry) = upper(?1) and upper(myVAllstockBasicprop.subpopulation) = upper(?2)  order by myVAllstockBasicprop.name"),

		@NamedQuery(name = "findVAllstockBasicpropByGsaccessionLike", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where myVAllstockBasicprop.gsAccession like ?1"),

		@NamedQuery(name = "findAllVAllstockBasicpropsDatasets", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop  where upper(myVAllstockBasicprop.dataset) in (?1)"),
		@NamedQuery(name = "findVAllstockBasicpropByBoxCodeDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.boxCode) = upper(?1) and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByBoxCodeContainingDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.boxCode) like upper(?1)  and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByallStockIdIdDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where myVAllstockBasicprop.allStockIdId = ?1  and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByIrisUniqueIdDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.irisUniqueId) = upper(?1) and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByIrisUniqueIdsDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.irisUniqueId) in (?1) and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByAccessionsDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.gsAccession) in (?1) and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByIrisUniqueIdContainingDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.irisUniqueId) like upper(?1) and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByNameDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.name) = upper(?1) and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByNameContainingDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.name) like upper(?1) and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByOriCountryDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.oriCountry) = upper(?1) and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByNamesDatasetWithSpace", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where (upper(myVAllstockBasicprop.name) in (?1) OR upper(replace(myVAllstockBasicprop.name, ' ', '')) in (?1)) AND upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByNamesDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.name) in (?1) and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByNamesLikeDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.name) like upper(?1)  and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByOriCountryContainingDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.oriCountry) like upper(?1) and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByPrimaryKeyDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where myVAllstockBasicprop.allStockIdId = ?1 and upper(myVAllstockBasicprop.dataset) in (?2)"),

		@NamedQuery(name = "findVAllstockBasicpropByPrimaryKeysDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where myVAllstockBasicprop.allStockIdId in (?1) and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropByNameGsaccessionDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.name) = upper(?1) and  upper(myVAllstockBasicprop.gsAccession) = upper(?2) and upper(myVAllstockBasicprop.dataset) in (?2)"),

		@NamedQuery(name = "findVAllstockBasicpropByGsaccessionDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.gsAccession) = upper(?1) and upper(myVAllstockBasicprop.dataset) in (?2)"),
		@NamedQuery(name = "findVAllstockBasicpropBySubpopulationDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.subpopulation) = upper(?1) and upper(myVAllstockBasicprop.dataset) in (?2)  order by myVAllstockBasicprop.name"),
		@NamedQuery(name = "findVAllstockBasicpropByOriCountrySubpopulationDataset", query = "select myVAllstockBasicprop from VAllstockBasicprop myVAllstockBasicprop where upper(myVAllstockBasicprop.oriCountry) = upper(?1) and upper(myVAllstockBasicprop.subpopulation) = upper(?2)  and upper(myVAllstockBasicprop.dataset) in (?3) order by myVAllstockBasicprop.name") })

// @Table( name = "V_allStockId_BASICPROP2")
// @Table( name = "V_allStockId_BASICPROP_3024")
@Table(name = "V_ALLSTOCK_BASICPROP")
// @Table(name = "TMP_allStockId_BASICPROP_3024")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "iric_prod_crud/org/irri/iric/portal/chado/oracle/domain", name = "VAllstockBasicprop")
public class VAllstockBasicprop implements Serializable, Variety{
	private static final long serialVersionUID = 1L;

	/**
	 */
	

	@Column(name = "STOCK_SAMPLE_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	BigDecimal stockSampleId;

	@Column(name = "STOCK_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	BigDecimal allStockIdId;
	/**
	 */

	@Column(name = "NAME")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 */

	// @Column(name = "IRIS_UNIQUE_ID", length = 4000)
	@Column(name = "ASSAY", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String irisUniqueId;
	/**
	 */

	@Column(name = "ORI_COUNTRY", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String oriCountry;
	/**
	 */

	@Column(name = "SUBPOPULATION", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String subpopulation;

	@Column(name = "BOX_CODE", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String boxCode;

	@Column(name = "GS_ACCESSION", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String gsAccession;

	@Column(name = "DATASET", length = 255)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String dataset;

	/**
	 */
	public void setallStockIdId(BigDecimal allStockIdId) {
		this.allStockIdId = allStockIdId;
	}

	/**
	 */
	public BigDecimal getallStockIdId() {
		return this.allStockIdId;
	}
	
	public BigDecimal getStockSampleId() {
		return stockSampleId;
	}
	
	public void setStockSampleId(BigDecimal stockSampleId) {
		this.stockSampleId = stockSampleId;
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
	public void setIrisUniqueId(String irisUniqueId) {
		this.irisUniqueId = irisUniqueId;
	}

	/**
	 */
	public String getIrisUniqueId() {
		/*
		 * if(this.irisUniqueId==null || this.irisUniqueId.isEmpty()) return
		 * getBoxCode(); else return this.irisUniqueId;
		 */
		return this.irisUniqueId;
	}

	/**
	 */
	public void setOriCountry(String oriCountry) {
		this.oriCountry = oriCountry;
	}

	/**
	 */
	public String getOriCountry() {
		return this.oriCountry;
	}

	/**
	 */
	public void setBoxCode(String boxCode) {
		this.boxCode = boxCode;
	}

	/**
	 */
	public String getBoxCode() {
		return this.boxCode;
	}

	/**
	 */
	public VAllstockBasicprop() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(VAllstockBasicprop that) {
		setallStockIdId(that.getallStockIdId());
		setName(that.getName());
		setIrisUniqueId(that.getIrisUniqueId());
		setOriCountry(that.getOriCountry());
		setBoxCode(that.getBoxCode());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("allStockIdId=[").append(allStockIdId).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("irisUniqueId=[").append(irisUniqueId).append("] ");
		buffer.append("oriCountry=[").append(oriCountry).append("] ");
		buffer.append("boxCode=[").append(boxCode).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((allStockIdId == null) ? 0 : allStockIdId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Stock))
			return false;
		VAllstockBasicprop equalCheck = (VAllstockBasicprop) obj;
		if ((allStockIdId == null && equalCheck.allStockIdId != null)
				|| (allStockIdId != null && equalCheck.allStockIdId == null))
			return false;
		if (allStockIdId != null && !allStockIdId.equals(equalCheck.allStockIdId))
			return false;
		return true;
	}

	public String getIrisId() {

		return this.getIrisUniqueId();
	}

	public String getCountry() {

		if (getOriCountry() == null)
			return "";
		return this.getOriCountry();
	}

	public String getSubpopulation() {

		if (subpopulation == null)
			return "";
		return this.subpopulation;
	}

	public void setCountry(String country) {

		this.oriCountry = country;

	}

	public void setSubpopulation(String subpopulation) {

		this.subpopulation = subpopulation;
	}

	public BigDecimal getVarietyId() {

		return this.getallStockIdId();
	}

	public int compareTo(Object o) {

		int ret = getName().compareTo(((Stock) o).getName());
		if (ret == 0)
			ret = getVarietyId().compareTo(((Stock) o).getVarietyId());

		return ret;
	}

	public String printFields(String delimiter) {

		String irisid = getIrisId();
		if (irisid == null)
			irisid = "";
		String subpop = getSubpopulation();
		if (subpop == null)
			subpop = "";
		String cntr = getCountry();
		if (cntr == null)
			cntr = "";
		// return this.getName() + delimiter + irisid + delimiter + subpop + delimiter +
		// cntr;
		// return "\""+ this.getName() + "\"" + delimiter + "\"" + irisid + "\"" +
		// delimiter + "\"" + subpop + "\"" + delimiter + "\"" + cntr + "\"";

		String acc = this.getAccession();
		if (acc == null)
			acc = "";

		// return this.getName() + delimiter + irisid + delimiter + subpop + delimiter +
		// cntr;
		return "\"" + this.getName() + "\"" + delimiter + "\"" + irisid + "\"" + delimiter + "\"" + acc + "\""
				+ delimiter + "\"" + subpop + "\"" + delimiter + "\"" + cntr + "\"";

	}

	public String getAccession() {

		if (this.gsAccession != null)
			return gsAccession;
		// else return this.getBoxCode();
		else
			return "";
	}

	public String getDataset() {

		// return VarietyFacade.DATASET_SNPINDELV2_IUPAC;
		return dataset;
	}

	public void setAccession(String accession) {

		// accession=accession.toUpperCase().replace("IRGC","").trim();
		this.gsAccession = accession;

	}

}