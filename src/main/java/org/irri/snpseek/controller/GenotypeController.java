package org.irri.snpseek.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.irri.snpseek.JSONException;
import org.irri.snpseek.DTO.GenotypeRequest;
import org.irri.snpseek.DTO.SnpRefPosIndex;
import org.irri.snpseek.service.GenotypeService;
import org.irri.snpseek.service.OrganismService;
import org.irri.snpseek.service.SnpFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/genotype")
@Tag(name = "Genotype", description = "API for genotyping experiment.")
public class GenotypeController {
	
	private final OrganismService organismDAO;
	private final GenotypeService genotypeService;
	private final SnpFeatureService snpFeatureService;

	@Autowired
	public GenotypeController(OrganismService organismDAO, GenotypeService genotypeService, SnpFeatureService snpFeatureService) {
		this.organismDAO = organismDAO;
		this.genotypeService = genotypeService;
		this.snpFeatureService = snpFeatureService;
	}
	
	@GetMapping("/gettableGenotype")
	@Operation(summary = "Genotype table (GET)", description = "Returns genotype table rows (placeholder)")
	public ResponseEntity<Map<String, Object>> getTableGenotype(
			@Parameter(description = "Returns only varieties in list of IDs. Multiple values must be comma-delimited, e.g. 1,2,3") @RequestParam(value = "organismId", required = false, defaultValue = "9") Integer organismId,
			@Parameter(description = "Dataset and variantset pairs. Use format dataset:variantset. Multiple pairs comma-delimited, e.g. 3k:3kfiltered,other:otherset") @RequestParam(value = "set", required = false, defaultValue = "3k:3kfiltered") String setPair,
			@Parameter(description = "Returns only varieties in list of IDs (comma separated)") @RequestParam(value = "varid", required = false, defaultValue = "all") String varid,
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
			@RequestParam(value = "alignindels", required = false) Boolean alignindels) {
		// Build a simple echo response containing the received parameters. Real
		// implementation should query the service layer.
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
		params.put("set", setPair);

		// parse setPair into dataset and variantset sets (format: dataset:variantset, multiple pairs comma-delimited)
		Set<String> sDataset = new HashSet<>();
		Set<String> sVSet = new HashSet<>();
		if (setPair != null && !setPair.trim().isEmpty()) {
			String[] pairs = setPair.split(",");
			for (String pair : pairs) {
				String t = pair.trim();
				if (t.isEmpty()) continue;
				int idx = t.indexOf(":");
				if (idx > -1) {
					String ds = t.substring(0, idx).trim();
					String vs = t.substring(idx + 1).trim();
					if (!ds.isEmpty()) sDataset.add(ds);
					if (!vs.isEmpty()) sVSet.add(vs);
				} else {
					// treat value as dataset only if no colon present
					if (!t.isEmpty()) sDataset.add(t);
				}
			}
		}

		params.put("datasetSet", sDataset);
		params.put("variantsetSet", sVSet);

		response.put("params", params);
		response.put("rows", Collections.emptyList());

		return ResponseEntity.ok(response);
	}

	@GetMapping("/refposindex")
	@Operation(summary = "SNP reference position index", description = "Returns SnpRefPosIndex entries for a locus and variantsets")
	public ResponseEntity<List<SnpRefPosIndex>> getRefPosIndex(
			@RequestParam(name = "organismId", required = false, defaultValue = "9") Long organismId,
			@RequestParam(name = "srcfeatureId") Long srcfeatureId,
			@RequestParam(name = "chromosome") Integer chromosome,
			@RequestParam(name = "start") Long start,
			@RequestParam(name = "end") Long end,
			@RequestParam(name = "variantset", required = false, defaultValue = "3kfiltered") String variantset) {

		List<SnpRefPosIndex> rows = snpFeatureService.getSnpRefPosIndex(organismId, srcfeatureId, chromosome, start, end, variantset);
		return ResponseEntity.ok(rows);
	}

	@PostMapping("/posttableGenotype")
	@Operation(summary = "Genotype table (POST)", description = "Accepts genotype table payload and returns a confirmation or processed result (placeholder)")
	public ResponseEntity<Map<String, Object>> postTableGenotype(
			@RequestBody(required = false) Map<String, Object> payload,
			@Parameter(description = "Returns only varieties in list of IDs. Multiple values must be comma-delimited, e.g. 1,2,3") @RequestParam(value = "varid", required = false, defaultValue = "all") String varid,
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
			@Parameter(description = "Dataset and variantset pairs. Use format dataset:variantset. Multiple pairs comma-delimited, e.g. 3k:3kfiltered,other:otherset") @RequestParam(value = "set", required = false, defaultValue = "3k:3kfiltered") String setPair)
			throws JSONException {
		// Echo back payload and params for now. Replace with actual processing logic as
		// needed.
		Map<String, Object> response = new HashMap<>();
		// guard against null varid just in case
		if (varid == null) {
			varid = "all";
		}
		// Validate input similar to legacy logic
		if (chr == null && locus == null && (poslist == null || poslist.isEmpty()))
			throw new JSONException("parameters (chr,start,end) OR locus OR (chr AND poslist) is required");

		if ((poslist == null || poslist.isEmpty()) && (start == null || end == null) && locus == null)
			throw new JSONException("parameters (start AND end) OR poslist OR locus is required");
		if (poslist != null && !poslist.isEmpty() && start != null && end != null)
			throw new JSONException("only one of either (start AND end) OR poslist is required");

		if (!"all".equals(varid) && subpopulation != null)
			throw new JSONException("only one of either varid OR subpopulation is required");

		// Build GenotypeRequest and delegate parsing/execution to service
		GenotypeRequest req = new GenotypeRequest();
		req.setVarid(varid);
		req.setChr(chr);
		req.setStart(start);
		req.setEnd(end);
		req.setSnp(snp);
		req.setIndel(indel);
		req.setCoreonly(coreonly);
		req.setMismatchonly(mismatchonly);
		req.setPoslist(poslist);
		req.setSubpopulation(subpopulation);
		req.setLocus(locus);
		req.setAlignindels(alignindels);
		req.setSet(setPair);
		req.setOrganismId(organismId);

		Map<String, Object> svcResult = genotypeService.getGenotypeTable(req);
		
		
		// include payload and return
		svcResult.put("payload", payload != null ? payload : Collections.emptyMap());
		return ResponseEntity.ok(svcResult);
	}

}
