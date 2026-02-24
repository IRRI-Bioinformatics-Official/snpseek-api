package org.irri.snpseek.controller; 


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/genotype")
@Tag(name = "Genotype",  description = "API for genotyping experiment.")
public class GenotypeController {
	
	@GetMapping("/gettableGenotype")
	@Operation(summary = "Genotype table (GET)", description = "Returns genotype table rows (placeholder)")
	public ResponseEntity<Map<String, Object>> getTableGenotype(
			@Parameter(description = "Returns only varieties in list of IDs. Multiple values must be comma-delimited, e.g. 1,2,3")
			@RequestParam(value = "organismId", required = false, defaultValue = "9") Integer organismId,
			@RequestParam(value = "dataset", required = false, defaultValue = "3k") String dataset,
			@RequestParam(value = "variantset", required = false, defaultValue = "3kfiltered") String variantset,
			@Parameter(description = "Returns only varieties in list of IDs (comma separated)")
			@RequestParam(value = "varid", required = false, defaultValue = "all") String varid,
			@RequestParam(value = "chr", required = false) String chr,
			@RequestParam(value = "start", required = false) Long start,
			@RequestParam(value = "end", required = false) Long end,
			@RequestParam(value = "snp", required = false) Boolean snp,
			@RequestParam(value = "indel", required = false) Boolean indel,
			@RequestParam(value = "coreonly", required = false) Boolean coreonly,
			@RequestParam(value = "mismatchonly", required = false) Boolean mismatchonly,
			@RequestParam(value = "poslist", required = false) String poslist,
			@RequestParam(value = "subpopulation", required = false) String subpopulation,
			@RequestParam(value = "locus", required = false) String locus,
			@RequestParam(value = "alignindels", required = false) Boolean alignindels
			) {
		// Build a simple echo response containing the received parameters. Real implementation should query the service layer.
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> params = new HashMap<>();
		params.put("varid", varid);
		params.put("chr", chr);
		params.put("start", start);
		params.put("end", end);
		params.put("snp", snp);
		params.put("indel", indel);
		params.put("coreonly", coreonly);
		params.put("mismatchonly", mismatchonly);
		params.put("poslist", poslist);
		params.put("subpopulation", subpopulation);
		params.put("locus", locus);
		params.put("alignindels", alignindels);
		params.put("organismId", organismId);
		params.put("variantset", variantset);
		params.put("dataset", dataset);

		response.put("params", params);
		response.put("rows", Collections.emptyList());

		return ResponseEntity.ok(response);
	}

	@PostMapping("/posttableGenotype")
	@Operation(summary = "Genotype table (POST)", description = "Accepts genotype table payload and returns a confirmation or processed result (placeholder)")
	public ResponseEntity<Map<String, Object>> postTableGenotype(
			@RequestBody(required = false) Map<String, Object> payload,
			@Parameter(description = "Returns only varieties in list of IDs. Multiple values must be comma-delimited, e.g. 1,2,3")
			@RequestParam(value = "varid", required = false) String varid,
			@RequestParam(value = "chr", required = false) String chr,
			@RequestParam(value = "start", required = false) Long start,
			@RequestParam(value = "end", required = false) Long end,
			@RequestParam(value = "snp", required = false) Boolean snp,
			@RequestParam(value = "indel", required = false) Boolean indel,
			@RequestParam(value = "coreonly", required = false) Boolean coreonly,
			@RequestParam(value = "mismatchonly", required = false) Boolean mismatchonly,
			@RequestParam(value = "poslist", required = false) String poslist,
			@RequestParam(value = "subpopulation", required = false) String subpopulation,
			@RequestParam(value = "locus", required = false) String locus,
			@RequestParam(value = "alignindels", required = false) Boolean alignindels,
			@RequestParam(value = "organismId", required = false) Integer organismId,
			@RequestParam(value = "variantset", required = false) String variantset,
			@RequestParam(value = "dataset", required = false) String dataset
			) {
		// Echo back payload and params for now. Replace with actual processing logic as needed.
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> params = new HashMap<>();
		params.put("varid", varid);
		params.put("chr", chr);
		params.put("start", start);
		params.put("end", end);
		params.put("snp", snp);
		params.put("indel", indel);
		params.put("coreonly", coreonly);
		params.put("mismatchonly", mismatchonly);
		params.put("poslist", poslist);
		params.put("subpopulation", subpopulation);
		params.put("locus", locus);
		params.put("alignindels", alignindels);
		params.put("organismId", organismId);
		params.put("variantset", variantset);
		params.put("dataset", dataset);

		response.put("params", params);
		response.put("payload", payload != null ? payload : Collections.emptyMap());

		return ResponseEntity.ok(response);
	}
	
	  
}