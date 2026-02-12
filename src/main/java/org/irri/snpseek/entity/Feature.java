package org.irri.snpseek.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;


import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 */

@Entity
@NamedQueries({ @NamedQuery(name = "findAllFeatures", query = "select myFeature from Feature myFeature"),
		@NamedQuery(name = "findFeatureByDbxrefId", query = "select myFeature from Feature myFeature where myFeature.dbxrefId = ?1"),
		@NamedQuery(name = "findFeatureByFeatureId", query = "select myFeature from Feature myFeature where myFeature.featureId = ?1"),
		@NamedQuery(name = "findFeatureByIsAnalysis", query = "select myFeature from Feature myFeature where myFeature.isAnalysis = ?1"),
		@NamedQuery(name = "findFeatureByIsObsolete", query = "select myFeature from Feature myFeature where myFeature.isObsolete = ?1"),
		@NamedQuery(name = "findFeatureByMd5checksum", query = "select myFeature from Feature myFeature where myFeature.md5checksum = ?1"),
		@NamedQuery(name = "findFeatureByMd5checksumContaining", query = "select myFeature from Feature myFeature where myFeature.md5checksum like ?1"),
		@NamedQuery(name = "findFeatureByName", query = "select myFeature from Feature myFeature where myFeature.name = ?1"),
		@NamedQuery(name = "findFeatureByNameContaining", query = "select myFeature from Feature myFeature where myFeature.name like ?1"),
		@NamedQuery(name = "findFeatureByOrganismId", query = "select myFeature from Feature myFeature where myFeature.organismId = ?1"),
		@NamedQuery(name = "findFeatureByOrganismIdAndUniqueName", query = "select myFeature from Feature myFeature where myFeature.organismId = ?1 and ( upper(myFeature.uniquename) like upper(?2) or upper(myFeature.name) like upper(?2))"),
		@NamedQuery(name = "findFeatureByPrimaryKey", query = "select myFeature from Feature myFeature where myFeature.featureId = ?1"),
		@NamedQuery(name = "findFeatureBySeqlen", query = "select myFeature from Feature myFeature where myFeature.seqlen = ?1"),
		@NamedQuery(name = "findFeatureByTimeaccessioned", query = "select myFeature from Feature myFeature where myFeature.timeaccessioned = ?1"),
		@NamedQuery(name = "findFeatureByTimelastmodified", query = "select myFeature from Feature myFeature where myFeature.timelastmodified = ?1"),
		@NamedQuery(name = "findFeatureByTypeId", query = "select myFeature from Feature myFeature where myFeature.typeId = ?1"),
		@NamedQuery(name = "findFeatureByUniquename", query = "select myFeature from Feature myFeature where myFeature.uniquename = ?1"),
		@NamedQuery(name = "findFeatureByUniquenameContaining", query = "select myFeature from Feature myFeature where myFeature.uniquename like ?1") })
@Table(name = "FEATURE")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "iric_prod_crud/org/irri/iric/portal/chado/domain", name = "Feature")
public class Feature implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "FEATURE_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer featureId;
	/**
	 */

	@Column(name = "DBXREF_ID", precision = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal dbxrefId;
	/**
	 */

	@Column(name = "ORGANISM_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer organismId;
	/**
	 */

	@Column(name = "NAME", length = 1020)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 */

	@Column(name = "RESIDUES")
	@Basic(fetch = FetchType.LAZY)
	// byte[] residues;
	String residues;
	/**
	 */

	@Column(name = "SEQLEN", precision = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal seqlen;
	/**
	 */

	@Column(name = "MD5CHECKSUM", length = 128)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String md5checksum;
	/**
	 */

	@Column(name = "TYPE_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal typeId;
	/**
	 */

	@Column(name = "IS_ANALYSIS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isAnalysis;
	/**
	 */

	@Column(name = "IS_OBSOLETE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isObsolete;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIMEACCESSIONED", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar timeaccessioned;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIMELASTMODIFIED", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar timelastmodified;
	/**
	 */

	@Column(name = "UNIQUENAME", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String uniquename;

	/**
	 */
	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	/**
	 */
	public Integer getFeatureId() {
		return this.featureId;
	}

	/**
	 */
	public void setDbxrefId(BigDecimal dbxrefId) {
		this.dbxrefId = dbxrefId;
	}

	/**
	 */
	public BigDecimal getDbxrefId() {
		return this.dbxrefId;
	}

	/**
	 */
	public void setOrganismId(Integer organismId) {
		this.organismId = organismId;
	}

	/**
	 */
	public Integer getOrganismId() {
		return this.organismId;
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
	public void setResidues(String residues) {
		this.residues = residues;
	}

//	/**
//	 */
//	public String getResidues() {
//		try {
//			return DbUtils.clobStringConversion(this.residues);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public void setResidues(String residues) {
//		
//
//	}

	/**
	 */
	public void setSeqlen(BigDecimal seqlen) {
		this.seqlen = seqlen;
	}

	/**
	 */
	public BigDecimal getSeqlen() {
		return this.seqlen;
	}

	/**
	 */
	public void setMd5checksum(String md5checksum) {
		this.md5checksum = md5checksum;
	}

	/**
	 */
	public String getMd5checksum() {
		return this.md5checksum;
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

	/**
	 */
	public void setIsAnalysis(Boolean isAnalysis) {
		this.isAnalysis = isAnalysis;
	}

	/**
	 */
	public Boolean getIsAnalysis() {
		return this.isAnalysis;
	}

	/**
	 */
	public void setIsObsolete(Boolean isObsolete) {
		this.isObsolete = isObsolete;
	}

	/**
	 */
	public Boolean getIsObsolete() {
		return this.isObsolete;
	}

	/**
	 */
	public void setTimeaccessioned(Calendar timeaccessioned) {
		this.timeaccessioned = timeaccessioned;
	}

	/**
	 */
	public Calendar getTimeaccessioned() {
		return this.timeaccessioned;
	}

	/**
	 */
	public void setTimelastmodified(Calendar timelastmodified) {
		this.timelastmodified = timelastmodified;
	}

	/**
	 */
	public Calendar getTimelastmodified() {
		return this.timelastmodified;
	}

	/**
	 */
	public void setUniquename(String uniquename) {
		this.uniquename = uniquename;
	}

	/**
	 */
	public String getUniquename() {
		return this.uniquename;
	}

	/**
	 */
	public Feature() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Feature that) {
		setFeatureId(that.getFeatureId());
		setDbxrefId(that.getDbxrefId());
		setOrganismId(that.getOrganismId());
		setName(that.getName());
		setResidues(that.getResidues());
		setSeqlen(that.getSeqlen());
		setMd5checksum(that.getMd5checksum());
		setTypeId(that.getTypeId());
		setIsAnalysis(that.getIsAnalysis());
		setIsObsolete(that.getIsObsolete());
		setTimeaccessioned(that.getTimeaccessioned());
		setTimelastmodified(that.getTimelastmodified());
		setUniquename(that.getUniquename());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("featureId=[").append(featureId).append("] ");
		buffer.append("dbxrefId=[").append(dbxrefId).append("] ");
		buffer.append("organismId=[").append(organismId).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("residues=[").append(residues).append("] ");
		buffer.append("seqlen=[").append(seqlen).append("] ");
		buffer.append("md5checksum=[").append(md5checksum).append("] ");
		buffer.append("typeId=[").append(typeId).append("] ");
		buffer.append("isAnalysis=[").append(isAnalysis).append("] ");
		buffer.append("isObsolete=[").append(isObsolete).append("] ");
		buffer.append("timeaccessioned=[").append(timeaccessioned).append("] ");
		buffer.append("timelastmodified=[").append(timelastmodified).append("] ");
		buffer.append("uniquename=[").append(uniquename).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((featureId == null) ? 0 : featureId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Feature))
			return false;
		Feature equalCheck = (Feature) obj;
		if ((featureId == null && equalCheck.featureId != null) || (featureId != null && equalCheck.featureId == null))
			return false;
		if (featureId != null && !featureId.equals(equalCheck.featureId))
			return false;
		return true;
	}

	public String getSequenceInPosition(long start, long end) {

		try {
			return this.residues.substring((int) start, (int) end);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public String getResidues() {
		return this.residues;
	}

}
