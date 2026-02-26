package org.irri.snpseek.domain.genotype;

import org.irri.snpseek.domain.GenotypeQueryParams;
import org.irri.snpseek.domain.genotype.snps.Position;

public interface VariantTableArray extends VariantTable {

	public Position[] getPosition();

	public String[] getReference();

	public Object[][] getVaralleles();

	public Long[] getVarid();

	public String[] getVarname();

	public Double[] getVarmismatch();

	// String[] getSNPGenomicAnnotation();

	String[] getSNPGenomicAnnotation(GenotypeQueryParams genotypeQueryParams);

}
