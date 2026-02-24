package org.irri.snpseek.entity;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;




@Entity(name = "VLocusMergedNotes")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "iric_prod_crud/org/irri/iric/portal/chado/domain", name = "VLocusMergedNotes")
public class VLocusMergedNotes  {

	@Column(name = "IRIC")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String iric;

	@Column(name = "RAP_REP")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String rapRep;

	@Column(name = "MSU7")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String msu7;

	@Column(name = "RAP_PRED")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String rapPred;

	@Column(name = "FGENESH")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String fgenesh;
	
	@Id
	@GeneratedValue
	@Column(name = "rownum")
	private Long rownum;

	public String getIRICName() {

		return iric;
	}

	public String getMSU7Name() {

		return msu7;
	}

	public String getRAPPredName() {

		return rapPred;
	}

	public String getRAPRepName() {

		return rapRep;
	}

	public String getFGeneshName() {

		return fgenesh;
	}

	public Set<String> getOverlappingGenes() {

		StringBuffer buff = new StringBuffer();
		buff.append(this.getName());
		if (getMSU7Name() != null && !getMSU7Name().isEmpty())
			buff.append(" " + getMSU7Name());
		if (getRAPRepName() != null && !getRAPRepName().isEmpty())
			buff.append(" " + getRAPRepName());
		if (getRAPPredName() != null && !getRAPPredName().isEmpty())
			buff.append(" " + getRAPPredName());

		Set locnamesets = new HashSet();
		String names[] = buff.toString().trim().split("\\s+|,");
		for (int i = 0; i < names.length; i++)
			locnamesets.add(names[i].trim());
		locnamesets.remove("");
		return locnamesets;

	}
	/*
	 * @Override public String printFields(String delimiter) { = return
	 * getUniquename() + delimiter + getContig() + delimiter + getFmin() + delimiter
	 * + getFmax() + delimiter + getStrand() + delimiter + getOverlappingGenes() +
	 * delimiter + getDescription(); }
	 */

	private Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
