package org.irri.snpseek.controller; 


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/genotype")
@Tag(name = "Genotype",  description = "API for genotyping experiment.")
public class GenotypeController {
	
	@GetMapping("/gettableGenotype")
	@Operation(summary = "Genotype table (GET)", description = "Returns genotype table rows (placeholder)")
	public ResponseEntity<List<Object>> getTableGenotype() {
		// Placeholder: return empty list until service is implemented
		return ResponseEntity.ok(Collections.emptyList());
	}

	@PostMapping("/posttableGenotype")
	@Operation(summary = "Genotype table (POST)", description = "Accepts genotype table payload and returns a confirmation or processed result (placeholder)")
	public ResponseEntity<Object> postTableGenotype(@RequestBody Map<String, Object> payload) {
		// Placeholder: echo back the received payload (or return an acknowledgement)
		return ResponseEntity.ok(payload != null ? payload : Collections.emptyMap());
	}
	  
}