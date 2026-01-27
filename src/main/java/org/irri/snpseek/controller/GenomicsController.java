package org.irri.snpseek.controller;

import org.irri.snpseek.entity.Gene;
import org.irri.snpseek.service.GenomicsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/genomics/gene/osnippo")
@Tag(name = "Genomics", description = "Genomic data queries")
public class GenomicsController {
	private final GenomicsService genomicsService;

	public GenomicsController(GenomicsService genomicsService) {
		this.genomicsService = genomicsService;
	}

	@GetMapping("/{contig}")
	@Operation(summary = "Genes by region", description = "Gets Nipponbare genes within region")
	public ResponseEntity<List<Gene>> getGeneByRegion(
			@Parameter(description = "Contig (ex. chr01)") @PathVariable String contig,
			@Parameter(description = "Start bp position") @RequestParam Long start,
			@Parameter(description = "End bp position") @RequestParam Long end,
			@Parameter(description = "Gene model [msu7 (default),rap,iric]") @RequestParam(required = false, defaultValue = "msu7") String model) {
		return ResponseEntity.ok(genomicsService.getGenesByRegion(contig, start, end, model));
	}
}