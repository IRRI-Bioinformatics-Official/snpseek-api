package org.irri.snpseek.controller;

import java.util.List;

import org.irri.snpseek.DTO.VarietyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.irri.snpseek.service.VarietyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/variety")
@Tag(name = "Variety", description = "API's to query variety related data")
public class VarietyController {
    private final VarietyService varietyService;

    public VarietyController(VarietyService varietyService) {
        this.varietyService = varietyService;
    }

    @GetMapping
    @Operation(summary = "All varieties", description = "Gets all variety objects")
    public ResponseEntity<List<VarietyDTO>> getVarieties() {
        return ResponseEntity.ok(varietyService.getAllVarieties());
    }
    
   
    @GetMapping("/{id}")
    @Operation(summary = "Variety details", description = "Gets variety details for varid")
    public ResponseEntity<VarietyDTO> getVarietiesById(
            @Parameter(description = "Variety ID") @PathVariable Long id) {
        return ResponseEntity.ok(varietyService.getVarietyById(id));
    }

    @GetMapping("/subpopulation/{subpop}")
    @Operation(summary = "Varieties in subpopulation", description = "Gets varieties in the subpopulation")
    public ResponseEntity<List<VarietyDTO>> getVarietiesBySubpopulation(
            @Parameter(description = "Subpopulation name") @PathVariable String subpop) {
        return ResponseEntity.ok(varietyService.getVarietiesBySubpopulation(subpop));
    }

    @GetMapping("/subpopulation")
    @Operation(summary = "Subpopulations", description = "Gets all subpopulations")
    public ResponseEntity<List<String>> getVarietiesSubpopulation() {
        return ResponseEntity.ok(varietyService.getAllSubpopulations());
    }

    @GetMapping("/country/{country}")
    @Operation(summary = "Varieties from country", description = "Gets all varieties from country")
    public ResponseEntity<List<VarietyDTO>> getVarietiesByCountry(
            @Parameter(description = "Country name") @PathVariable String country) {
        return ResponseEntity.ok(varietyService.getVarietiesByCountry(country));
    }

    @GetMapping("/country")
    @Operation(summary = "Countries", description = "Gets all countries")
    public ResponseEntity<List<String>> getVarietiesCountry() {
        return ResponseEntity.ok(varietyService.getAllCountries());
    }

    @GetMapping("/name")
    @Operation(summary = "Variety names", description = "Gets all variety names")
    public ResponseEntity<List<String>> getVarietiesNames() {
        return ResponseEntity.ok(varietyService.getAllVarietyNames());
    }

    @GetMapping("/namelike/{name}")
    @Operation(summary = "Variety names like", description = "Gets all varieties with names using wildcard *name*")
    public ResponseEntity<List<VarietyDTO>> getVarietiesNameLike(
            @Parameter(description = "Name pattern") @PathVariable String name) {
        return ResponseEntity.ok(varietyService.getVarietiesByNameLike(name));
    }
}
