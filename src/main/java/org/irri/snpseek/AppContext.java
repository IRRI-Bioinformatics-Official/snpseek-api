package org.irri.snpseek;

import java.util.HashMap;
import java.util.Map;

public class AppContext {

	private static Map<String, Integer> mapVariant2Order;

	public static Integer REFERENCE_NIPPONBARE_ID() {
		return 9;
	}

	private static String getDefaultOrganism() {

		return "Japonica nipponbare";
	}

	/**
	 * Guess the chromosome number from contig name
	 * 
	 * @param chr
	 * @return
	 */
	public static String guessChrFromString(String chr) {
		return chr.toUpperCase().replace("CHR0", "").replace("CHR", "");
	}

	public static Object REFERENCE_NIPPONBARE() {
		return AppContext.getDefaultOrganism();
	}

	public static Integer getMapVariantRank(String annot) {

		if (mapVariant2Order == null) {
			mapVariant2Order = new HashMap();
			mapVariant2Order.put("chromosome_number_variation", 1);
			mapVariant2Order.put("exon_loss_variant", 2);
			mapVariant2Order.put("frameshift_variant", 3);
			mapVariant2Order.put("stop_gained", 4);
			mapVariant2Order.put("stop_lost", 5);
			mapVariant2Order.put("start_lost", 6);
			mapVariant2Order.put("splice_acceptor_variant", 7);
			mapVariant2Order.put("splice_donor_variant", 8);
			mapVariant2Order.put("rare_amino_acid_variant", 9);
			mapVariant2Order.put("missense_variant", 10);
			mapVariant2Order.put("inframe_insertion", 11);
			mapVariant2Order.put("disruptive_inframe_insertion", 12);
			mapVariant2Order.put("inframe_deletion", 13);
			mapVariant2Order.put("disruptive_inframe_deletion", 14);
			mapVariant2Order.put("5_prime_UTR_truncation+exon_loss_variant", 15);
			mapVariant2Order.put("3_prime_UTR_truncation+exon_loss", 16);
			mapVariant2Order.put("splice_branch_variant", 17);
			mapVariant2Order.put("splice_region_variant", 18);
			mapVariant2Order.put("splice_branch_variant", 19);
			mapVariant2Order.put("stop_retained_variant", 20);
			mapVariant2Order.put("initiator_codon_variant", 21);
			mapVariant2Order.put("synonymous_variant", 22);
			mapVariant2Order.put("initiator_codon_variant+non_canonical_start_codon", 23);
			mapVariant2Order.put("stop_retained_variant", 24);
			mapVariant2Order.put("coding_sequence_variant", 25);
			mapVariant2Order.put("5_prime_UTR_variant", 26);
			mapVariant2Order.put("3_prime_UTR_variant", 27);
			mapVariant2Order.put("5_prime_UTR_premature_start_codon_gain_variant", 28);
			mapVariant2Order.put("upstream_gene_variant", 29);
			mapVariant2Order.put("downstream_gene_variant", 30);
			mapVariant2Order.put("TF_binding_site_variant", 31);
			mapVariant2Order.put("regulatory_region_variant", 32);
			mapVariant2Order.put("miRNA", 33);
			mapVariant2Order.put("custom", 34);
			mapVariant2Order.put("sequence_feature", 35);
			mapVariant2Order.put("conserved_intron_variant", 36);
			mapVariant2Order.put("intron_variant", 37);
			mapVariant2Order.put("intragenic_variant", 38);
			mapVariant2Order.put("conserved_intergenic_variant", 39);
			mapVariant2Order.put("intergenic_region", 40);
			mapVariant2Order.put("coding_sequence_variant", 41);
			mapVariant2Order.put("non_coding_exon_variant", 42);
			mapVariant2Order.put("nc_transcript_variant", 43);
			mapVariant2Order.put("gene_variant", 44);
			mapVariant2Order.put("chromosome", 45);
		}

		return (Integer) mapVariant2Order.get(annot);

	}

}
