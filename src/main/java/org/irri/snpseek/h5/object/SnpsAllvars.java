package org.irri.snpseek.h5.object;

import java.math.BigDecimal;

import org.irri.snpseek.domain.genotype.snps.Position;

/**
 * Container entity for SNP-Genotype data
 * 
 * @author lmansueto
 *
 */
public interface SnpsAllvars extends Position {

	/**
	 * Variety Id
	 * 
	 * @return
	 */
	public BigDecimal getVar();

	/**
	 * Variety allele at the position
	 * 
	 * @return
	 */
	public String getVarnuc();

}
