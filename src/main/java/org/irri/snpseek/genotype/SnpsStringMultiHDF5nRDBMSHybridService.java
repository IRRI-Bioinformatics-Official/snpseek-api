package org.irri.snpseek.genotype;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.irri.snpseek.domain.Position;

public class SnpsStringMultiHDF5nRDBMSHybridService {
	
	static Set<Character> charMissing = new HashSet<Character>(Arrays.asList('0', '.', '?'));
	static Set<Character> charSameasAllele1 = new HashSet<Character>(Arrays.asList('*'));
	static Set<Character> charSymbols = new HashSet<Character>(Arrays.asList('0', '.', '?', '*'));


	/**
	 * Count mismatch between nucelotide sequences, based on several criteria
	 * 
	 * @param var1                 variety 1 allele1 string
	 * @param var2                 variety 2 allele1 string
	 * @param var1isref            variety 1 is reference
	 * @param var1allele2str       variety 1 allele2 string
	 * @param var2allele2str       variety 2 allele2 string
	 * @param mapIdx2NonsynAlleles map table index 2 nonsysynonymous nucleotide set
	 * @param setSnpInExonTableIdx set of table indices in exon
	 * @param setNonsynIdx         set of table indices with nonsynonymous (return
	 *                             value)
	 * @param isNonsynOnly         include only nonsynonymous
	 * @param isColorSynGray       color nonsynonymous as gray
	 * @return
	 */

	public static double[] countVarpairMismatch(List listpos, String var1, String var2, boolean var1isref,
			Map<Position, Character> var1allele2str, Map<Position, Character> var2allele2str,
			Map<Position, Set<Character>> mapPos2NonsynAlleles, Set<Position> setNonsynPos, boolean isNonsynOnly,
			boolean countMissing05) {

		double misCount = 0;
		double matchCount = 0;
		for (int iStr = 0; iStr < var2.length(); iStr++) {
			char var1char = var1.charAt(iStr);
			char var2char = var2.charAt(iStr);

			// boolean snpInExon = false;
			// if(setSnpInExonTableIdx==null || (setSnpInExonTableIdx!=null &&
			// setSnpInExonTableIdx.contains(iStr))) snpInExon=true;

			Position pos = (Position) listpos.get(iStr);

			Boolean isNonsyn[] = new Boolean[2];
			isNonsyn[0] = false;
			isNonsyn[1] = false;
			Character var1allele2 = null;
			if (!var1isref && var1allele2str != null)
				var1allele2 = var1allele2str.get(iStr);

			Character var2allele2 = null;
			if (var2allele2str != null)
				var2allele2 = var2allele2str.get(pos);
			Set setNonsyns = mapPos2NonsynAlleles.get(pos);

			double mismatchCount[] = countVarpairMismatchNuc(var1.charAt(iStr), var2.charAt(iStr), var1isref,
					var1allele2, var2allele2, setNonsyns, isNonsyn, isNonsynOnly, countMissing05);

			// AppContext.debug( "var1=" + var1.charAt(iStr) +"/" + var1allele2 + ", var2="
			// + var2.charAt(iStr)+"/"+ var2allele2 + " mis=" + mismatchCount[0] + ",match="
			// + mismatchCount[1] + ", 0.5missing="+countMissing05);

			misCount += mismatchCount[0];
			matchCount += mismatchCount[1];

			if (isNonsyn[0] || isNonsyn[1])
				setNonsynPos.add(pos);
		}

		return new double[] { misCount, matchCount };
	}
	
	public static double[] countVarpairMismatchNuc(char var1char, char var2char, boolean var1isref,
			Character var1allele2, Character var2allele2, Set<Character> setNonsynAlleles, Boolean isNonsyn[],
			boolean isNonsynOnly, boolean countMissing05) {
		double misCount = 0;
		double matchCount = 0;

		Character var2allele1 = null;
		Character var1allele1 = null;

		isNonsyn[0] = false;
		isNonsyn[1] = false;
		// boolNonsyn = false;

		// initialize missing to null, * to homozygous allele
		if (!charMissing.contains(var1char))
			var1allele1 = var1char;
		if (!charMissing.contains(var2char))
			var2allele1 = var2char;

		if (var2allele2 != null) {
			if (charSameasAllele1.contains(var2allele2))
				var2allele2 = var2allele1;
			else if (charMissing.contains(var2allele2))
				var2allele2 = null;
		} else
			var2allele2 = var2allele1;

		if (var1allele2 != null) {
			if (charSameasAllele1.contains(var1allele2))
				var1allele2 = var1allele1;
			else if (charMissing.contains(var1allele2))
				var1allele2 = null;
		} else
			var1allele2 = var1allele1;

		// check for non-syn
		// if(isNonsynOnly) {
		if (true) {
			// reference comparison
			if (var1isref) {
				if (var2allele1 != null) {
					if (!charSymbols.contains(var2allele1)) {
						if (true) {
							// idx in exon
							if (setNonsynAlleles != null && (setNonsynAlleles.contains(var2allele1)))
								// var2 allele1 or allele2 in nonsynonymous
								isNonsyn[0] = true;
							if (var2allele2 != null && setNonsynAlleles != null && !charSymbols.contains(var2allele2)
									&& setNonsynAlleles.contains(var2allele2))
								// var2 allele1 or allele2 in nonsynonymous
								isNonsyn[1] = true;
						} else {
							// not in exon, OR no exon information, include in nonsynonymous
							// isNonsyn[0]=true;
							// isNonsyn[1]=true;
						}
					}

					// if allele1 and allele2 are both synonymous
					if (!isNonsyn[0] && !isNonsyn[1] && isNonsynOnly)
						return new double[] { 0, 1 };

				} else {
					if (countMissing05) {
						return new double[] { 0.5, 0.5 };
					} else {
						return new double[] { 0, 0 };
					}
				}
			} else {
				// pairwise comparison
				if (var1allele1 != null) {
					if (setNonsynAlleles != null && (setNonsynAlleles.contains(var1allele1)
							|| (var1allele2 != null && setNonsynAlleles.contains(var1allele2))))
						// var1 is not reference, and var1 allele1 or allele2 in nonsynonymous
						isNonsyn[0] = true;
				}

				if (var2allele1 != null) {
					if (setNonsynAlleles != null && (setNonsynAlleles.contains(var2allele1)
							|| (var2allele2 != null && setNonsynAlleles.contains(var2allele2))))
						// var1 is not reference, and var1 allele1 or allele2 in nonsynonymous
						isNonsyn[1] = true;
				}

				// if one or both are missing
				if (var1allele1 == null || var2allele1 == null) {
					if (countMissing05) {
						return new double[] { 0.5, 0.5 };
					} else {
						return new double[] { 0, 0 };
					}
				}

				// if allele1 and allele2 are both synonymous
				if (!isNonsyn[0] && !isNonsyn[1] && isNonsynOnly)
					return new double[] { 0, 1 };
			}
			// synonymous, not mismatch
			// if(!isNonsyn[0] && !isNonsyn[1]) return new double[]{0,1};
		}
		// if(isNonsynOnly && !isNonsyn[0] && !isNonsyn[1]) return 0;

		if (var1isref) {
			// compare with reference

			// assump: no 0 * . $ characters in reference
			// if homozygous, mismatch allele1, miscount +1
			// if heterozygous, match allele1 or allele2, miscount +0.5
			// if not nonsynonymos and isNonsynOnly , no count

			if (var2allele1 == null) {
				if (countMissing05) {
					misCount += 0.5;
					matchCount += 0.5;
				}
			} else {
				// var2allele1 IS NOT MISSING
				if (var1allele1 == var2allele1)
					matchCount += 0.5;
				else
					misCount += 0.5;

				if (var2allele2 != null) {
					if (var1allele1 == var2allele2)
						matchCount += 0.5;
					else
						misCount += 0.5;
				} else if (var2allele2 == null && var2allele1 != null) {
					throw new RuntimeException("Unexpected case: var2allele1!=null=" + var2allele1
							+ " ,var2allele2==null, var1allele1=" + var1allele1 + ", var1allele2=" + var1allele2);
				}
				// else throw new RuntimeException("Unexpected case:
				// var2allele1!=null,var2allele2==null");
			}

		} else {
			// pairwise comparison

			if (charMissing.contains(var1allele1) || charMissing.contains(var2allele1) || var1allele1 == null
					|| var2allele1 == null) {
				if (countMissing05) {
					misCount += 0.5;
					matchCount += 0.5;
				}
			} else {
				if ((var1allele1 == var2allele1 && var1allele2 == var2allele2)
						|| (var1allele1 == var2allele2 && var1allele2 == var2allele1)) {
					matchCount += 1;
				} else if ((var1allele1 == var2allele1 && var1allele2 != var2allele2)
						|| (var1allele1 == var2allele2 && var1allele2 != var2allele1)) {
					matchCount += 0.5;
					misCount += 0.5;
				} else {
					misCount += 1;
				}

			}

		}
		return new double[] { misCount, matchCount };
	}


}
