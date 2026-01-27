package org.irri.snpseek.controller;

import org.irri.snpseek.DTO.BlastRequest;
import org.irri.snpseek.service.BlastService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/blast")
@Tag(name = "BLAST", description = "BLAST search against reference genomes")
public class BlastController {
	private final BlastService blastService;

	public BlastController(BlastService blastService) {
		this.blastService = blastService;
	}

	@GetMapping("/getblast")
	@Operation(summary = "BLAST", description = "BLAST the five reference rice genomes (for long sequence, use /blast/postblast)")
	public ResponseEntity<Map<String, Object>> getBlast(
			@Parameter(description = "Nucleotide or protein sequence") @RequestParam(required = false) String sequence,
			@Parameter(description = "BLAST program to use (blastn, blastp, blastx, tblastn, tblastx)") @RequestParam(required = false) String program,
			@Parameter(description = "Database to query") @RequestParam(required = false) String db,
			@Parameter(description = "Maximum E-value (default 10)") @RequestParam(required = false, defaultValue = "10") Double maxe) {

		BlastRequest request = new BlastRequest();
		request.setSequence(sequence);
		request.setProgram(program);
		request.setDb(db);
		request.setMaxe(maxe);

		return ResponseEntity.ok(blastService.runBlast(request));
	}

	@PostMapping("/postblast")
	@Operation(summary = "BLAST", description = "BLAST the five reference rice genomes (use for long sequence)")
	public ResponseEntity<Map<String, Object>> postBlast(
			@Parameter(description = "Request body") @RequestBody BlastRequest request) {
		return ResponseEntity.ok(blastService.runBlast(request));
	}
}