package org.irri.snpseek.controller;

import org.irri.snpseek.service.PassportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/variety")
@Tag(name = "Passport", description = "Passport data queries")
public class PassportController {
	private final PassportService passportService;

	public PassportController(PassportService passportService) {
		this.passportService = passportService;
	}

	@GetMapping("/passports")
	@Operation(summary = "All passports", description = "Gets all passport fields and IDs")
	public ResponseEntity<List<String>> getPassports() {
		return ResponseEntity.ok(passportService.getAllPassportFields());
	}

	@GetMapping("/{varid}/passports")
	@Operation(summary = "Variety passports", description = "Gets all passport data for varid")
	public ResponseEntity<Map<String, String>> getVarietyPassports(
			@Parameter(description = "Variety ID") @PathVariable Long varid) {
		return ResponseEntity.ok(passportService.getVarietyPassports(varid));
	}

	@GetMapping("/passports/{passid}")
	@Operation(summary = "Passport data", description = "Gets all passport field and values for varid")
	public ResponseEntity<Map<String, String>> getPassport4AllVarieties(
			@Parameter(description = "Passport ID") @PathVariable String passid) {
		return ResponseEntity.ok(passportService.getPassportForAllVarieties(passid));
	}
}