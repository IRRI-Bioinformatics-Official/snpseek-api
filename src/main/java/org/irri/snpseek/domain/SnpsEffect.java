package org.irri.snpseek.domain;

import java.util.List;

import org.irri.snpseek.domain.impl.SnpEffectAnn;

public interface SnpsEffect extends Locus {

	String[] getANN();

	String[] getLOF();

	String[] getNMD();

	String getAnnotation();

	Double getScore();

	List<SnpEffectAnn> getANNObj();

	String getSnpset();

}
