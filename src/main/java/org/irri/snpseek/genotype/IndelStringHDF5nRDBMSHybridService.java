package org.irri.snpseek.genotype;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.irri.snpseek.domain.IndelsAllvarsPos;
import org.irri.snpseek.domain.SnpsEffect;
import org.irri.snpseek.domain.VariantStringService;
import org.irri.snpseek.domain.impl.IndelsAllvarsPosAlleleImpl;
import org.irri.snpseek.h5.object.SnpsAllvarsPos;

public class IndelStringHDF5nRDBMSHybridService implements VariantStringService {

	public static int getIndelType(IndelsAllvarsPos ip) {

		IndelsAllvarsPosAlleleImpl indelpos = (IndelsAllvarsPosAlleleImpl) ip;
		int ret = -1;

		return getIndelType(indelpos.getInsString());
	}
	
	/**
	 * Get type of Indel
	 * 
	 * @param allele
	 * @return
	 */
	public static int getIndelType(String allele) {

		int ret = -1;
		if (allele.equals(".") || allele.equals("ref"))
			ret = INDELTYPE_REFERENCE;
		else if (allele.equals("?") || allele.equals(" ") || allele.isEmpty())
			ret = INDELTYPE_MISSING;
		else if (allele.contains("->"))
			ret = INDELTYPE_SUBSTITUTION;
		else if (allele.startsWith("del")) {
			ret = INDELTYPE_DELETION;
		} else if (allele.startsWith("extdel") || (allele.length() > 0 && allele.charAt(0) == '-')) {
			ret = INDELTYPE_EXTENDDELETION;
		} else {
			try {
				Integer.valueOf(allele);
				ret = INDELTYPE_DELETION;
			} catch (Exception ex) {
				ret = INDELTYPE_INSERTION;
			}
		}
		return ret;
	}

	@Override
	public VariantStringData getVariantString(GenotypeQueryParams params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countVariantString(GenotypeQueryParams params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List checkSNPsInChromosome(Integer organismId, String chr, Collection posset, Set variantset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SnpsEffect> getSnpsEffects(List positions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SnpsAllvarsPos> getSNPPoslist(GenotypeQueryParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countSNPPoslist(GenotypeQueryParams params) {
		// TODO Auto-generated method stub
		return 0;
	}

}
