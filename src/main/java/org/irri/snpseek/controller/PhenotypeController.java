package org.irri.snpseek.controller;

import org.irri.snpseek.DTO.*;
import org.irri.snpseek.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/variety")
@Tag(name = "Phenotype", description = "Phenotype data queries")
public class PhenotypeController {
	private final PhenotypeService phenotypeService;

	public PhenotypeController(PhenotypeService phenotypeService) {
		this.phenotypeService = phenotypeService;
	}

	@GetMapping("/phenotypes")
	@Operation(summary = "All phenotypes", description = "Gets all phenotype names and IDs")
	public ResponseEntity<List<PhenotypeDTO>> getPhenotypes() {
		return ResponseEntity.ok(phenotypeService.getAllPhenotypes());
	}

	@GetMapping("/phenotypes/{phenid}")
	@Operation(summary = "Phenotype values", description = "Gets value for phenid in all varieties")
	public ResponseEntity<Map<String, String>> getPhenotype4AllVarieties(
			@Parameter(description = "Phenotype ID") @PathVariable String phenid) {
		return ResponseEntity.ok(phenotypeService.getPhenotypeForAllVarieties(phenid));
	}

	@GetMapping("/{varid}/phenotypes")
	@Operation(summary = "All phenotypes and values for variety", description = "Gets all phenotypes and values for varid")
	public ResponseEntity<Map<String, String>> getVarietyAllPhenotypes(
			@Parameter(description = "Variety ID") @PathVariable Long varid) {
		return ResponseEntity.ok(phenotypeService.getAllPhenotypesForVariety(varid));
	}

	@GetMapping("/{varid}/phenotypes/{phenid}")
	@Operation(summary = "Phenotype value for variety", description = "Get phenotype phenId value for varid")
	public ResponseEntity<String> getVarietyPhenotype(@Parameter(description = "Variety ID") @PathVariable Long varid,
			@Parameter(description = "Phenotype ID") @PathVariable String phenid) {
		return ResponseEntity.ok(phenotypeService.getVarietyPhenotype(varid, phenid));
	}

	@GetMapping("/all/phenotypes/{phenid}")
	@Operation(summary = "Phenotype value for all varieties", description = "Get phenotype values for all varieties")
	public ResponseEntity<Map<String, String>> getAllVarietyPhenotype(
			@Parameter(description = "Phenotype ID") @PathVariable String phenid) {
		return ResponseEntity.ok(phenotypeService.getPhenotypeForAllVarieties(phenid));
	}
}