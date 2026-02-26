package org.irri.snpseek.domain.genotype;

import java.util.List;

import org.irri.snpseek.domain.GenotypeQueryParams;
import org.irri.snpseek.domain.VariantStringData;

public interface VariantTable {

	/**
	 * Set the data from genotype database query result
	 * 
	 * @param data
	 */
	// public void setVariantStringData(VariantStringData data);
	public VariantStringData getVariantStringData();

	/**
	 * Set messsage to display to interface
	 * 
	 * @return
	 */
	public String getMessage();

	public void setMessage(String message);

	/**
	 * Recreate result based on param settings, without requery to the database
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	// public VariantTable review(GenotypeQueryParams params );
	void setVariantStringData(VariantStringData data, GenotypeQueryParams params) throws Exception;

	/*
	 * to remove non-CDS positions
	 */
	void setVariantStringData(VariantStringData data, GenotypeQueryParams params, List listCDS) throws Exception;

	public String[] getContigs();

	// public Long[] getPosition();
	//
	// public String[] getReference();
	//
	// public Object[][] getVaralleles();
	//
	// public Long[] getVarid();
	//
	// public String[] getVarname();
	//
	// public Double[] getVarmismatch();

}
