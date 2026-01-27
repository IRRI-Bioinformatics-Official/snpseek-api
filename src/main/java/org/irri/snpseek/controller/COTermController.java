package org.irri.snpseek.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/variety/COterms/trait")
@Tag(name = "CO Terms", description = "Crop Ontology term queries")
public class COTermController {
	@GetMapping
	@Operation(summary = "All rice ontologies", description = "Gets all CO Term Names")
	public ResponseEntity<Map<String, Object>> getCoTerms() {
	    // TODO: Implement
	    Map<String, Object> result = new HashMap<>();
	    result.put("message", "CO Terms - Implementation needed");
	    return ResponseEntity.ok(result);
	}

	@GetMapping("/{coTerm}")
	@Operation(summary = "Ontology terms", description = "Gets value for coterms in all varieties")
	public ResponseEntity<Map<String, Object>> getCOTerm4AllVarities(
	        @Parameter(description = "CO Term") @PathVariable String coTerm) {
	    // TODO: Implement
	    Map<String, Object> result = new HashMap<>();
	    result.put("message", "CO Term for all varieties - Implementation needed");
	    result.put("coTerm", coTerm);
	    return ResponseEntity.ok(result);
	}

	@GetMapping("/{varid}/COterms/trait/{coTerm}")
	@Operation(summary = "CO Term value for variety", description = "Get coterms value for varid")
	public ResponseEntity<Map<String, Object>> getVarietyCOTerm(
	        @Parameter(description = "Variety ID") @PathVariable String varid,
	        @Parameter(description = "CO Term") @PathVariable String coTerm) {
	    // TODO: Implement
	    Map<String, Object> result = new HashMap<>();
	    result.put("message", "CO Term for variety - Implementation needed");
	    result.put("varid", varid);
	    result.put("coTerm", coTerm);
	    return ResponseEntity.ok(result);
	}
}