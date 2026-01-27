package org.irri.snpseek.controller;

import org.irri.snpseek.DTO.GenotypeRequest;
import org.irri.snpseek.service.GenotypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/genotype")
@Tag(name = "Genotype", description = "Genotype data queries")
public class GenotypeController {
	private final GenotypeService genotypeService;

	public GenotypeController(GenotypeService genotypeService) {
		this.genotypeService = genotypeService;
	}

	@GetMapping("/gettable")
	@Operation(summary = "Genotype table", description = "Gets SNP/Indels genotype table (for large list of variety IDs or positions, use /genotype/posttable)")
	public ResponseEntity<Map<String, Object>> getVariantByVarietyId(
			@Parameter(description = "Returns only varieties in list of IDs (comma separated)") @RequestParam(required = false) String varid,
			@Parameter(description = "Contig name (ex. chr01)") @RequestParam(required = false) String chr,
			@Parameter(description = "Start bp position") @RequestParam(required = false) Long start,
			@Parameter(description = "End bp position") @RequestParam(required = false) Long end,
			@Parameter(description = "Query SNPs") @RequestParam(required = false) Boolean snp,
			@Parameter(description = "Query indels") @RequestParam(required = false) Boolean indel,
			@Parameter(description = "Query core SNPs only") @RequestParam(required = false) Boolean coreonly,
			@Parameter(description = "Returns only varieties with mismatch") @RequestParam(required = false) Boolean mismatchonly,
			@Parameter(description = "List of bp positions (comma separated)") @RequestParam(required = false) String poslist,
			@Parameter(description = "Returns only varieties in subpopulation") @RequestParam(required = false) String subpopulation,
			@Parameter(description = "Query in locus region (MSU7 locus names)") @RequestParam(required = false) String locus,
			@Parameter(description = "Show indels as aligned sequences, starting at anchor position") @RequestParam(required = false) Boolean alignindels) {

		GenotypeRequest request = new GenotypeRequest();
		request.setVarid(varid);
		request.setChr(chr);
		request.setStart(start);
		request.setEnd(end);
		request.setSnp(snp);
		request.setIndel(indel);
		request.setCoreonly(coreonly);
		request.setMismatchonly(mismatchonly);
		request.setPoslist(poslist);
		request.setSubpopulation(subpopulation);
		request.setLocus(locus);
		request.setAlignindels(alignindels);

		return ResponseEntity.ok(genotypeService.getGenotypeTable(request));
	}

	@PostMapping("/posttable")
	@Operation(summary = "Genotype table", description = "Gets SNP/Indels genotype table (use for large list of variety IDs or positions)")
	public ResponseEntity<Map<String, Object>> postVariantByVarietyId(
			@Parameter(description = "Request body") @RequestBody GenotypeRequest request) {
		return ResponseEntity.ok(genotypeService.getGenotypeTable(request));
	}
}