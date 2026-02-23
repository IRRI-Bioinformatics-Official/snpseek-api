package org.irri.snpseek.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.irri.snpseek.DTO.VarietyDTO;
import org.irri.snpseek.service.VAllstockBasicpropService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/variety")
@Tag(name = "Variety", description = "API for genotyping experiment runs and variant calling datasets")
public class VarietyController {

    private final VAllstockBasicpropService allstockService;

    public VarietyController(VAllstockBasicpropService allstockService) {
        this.allstockService = allstockService;
    }

    @GetMapping
    @Operation(summary = "All varieties", description = "Get all varieties (supports limit query param)")
    public ResponseEntity<List<VarietyDTO>> getVarietyAll(@RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        return ResponseEntity.ok(allstockService.findAllVAllstockBasicprops(limit));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Variety details", description = "Get variety details by id")
    public ResponseEntity<Object> getVarietyById(@PathVariable Long id) {
        return ResponseEntity.ok(Collections.emptyMap());
    }

    @GetMapping("/subpopulation/{subpop}")
    @Operation(summary = "Varieties in subpopulation", description = "Get varieties in a subpopulation")
    public ResponseEntity<List<Object>> getVarietiesBySubpopulation(@PathVariable String subpop,
            @RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/subpopulation")
    @Operation(summary = "Subpopulations", description = "Get list of subpopulations")
    public ResponseEntity<List<String>> getVarietySubpopulations() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/country/{country}")
    @Operation(summary = "Varieties from country", description = "Get varieties originating from a country")
    public ResponseEntity<List<Object>> getVarietiesByCountry(@PathVariable String country,
            @RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/country")
    @Operation(summary = "Countries", description = "Get list of countries")
    public ResponseEntity<List<String>> getVarietyCountries() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/name")
    @Operation(summary = "Variety names", description = "Get all variety names")
    public ResponseEntity<List<String>> getVarietyNames() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/namelike/{name}")
    @Operation(summary = "Variety names like", description = "Get variety names matching pattern")
    public ResponseEntity<List<String>> getVarietyNameLike(@PathVariable String name) {
        return ResponseEntity.ok(Collections.emptyList());
    }

    // Phenotype endpoints (mirrors PhenotypeController routes)
    @GetMapping("/phenotypes")
    @Operation(summary = "All phenotypes", description = "Get all phenotype names and IDs")
    public ResponseEntity<List<Object>> getPhenotypes() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/phenotypes/{phenid}")
    @Operation(summary = "Phenotype values", description = "Get phenotype values for all varieties")
    public ResponseEntity<Map<String, String>> getPhenotypeForAllVarieties(@PathVariable String phenid) {
        return ResponseEntity.ok(Collections.emptyMap());
    }

    @GetMapping("/{varid}/phenotypes")
    @Operation(summary = "Variety phenotypes", description = "Get all phenotypes and values for a variety")
    public ResponseEntity<Map<String, String>> getVarietyPhenotypes(@PathVariable Long varid) {
        return ResponseEntity.ok(Collections.emptyMap());
    }

    @GetMapping("/{varid}/phenotypes/{phenid}")
    @Operation(summary = "Variety phenotype value", description = "Get phenotype value for a variety")
    public ResponseEntity<String> getVarietyPhenotype(@PathVariable Long varid, @PathVariable String phenid) {
        return ResponseEntity.ok("");
    }

    @GetMapping("/all/phenotypes/{phenid}")
    @Operation(summary = "Phenotype values for all varieties", description = "Get phenotype values for all varieties")
    public ResponseEntity<Map<String, String>> getAllVarietyPhenotype(@PathVariable String phenid) {
        return ResponseEntity.ok(Collections.emptyMap());
    }

    // COterms / ontology endpoints
    @GetMapping("/COterms/trait")
    @Operation(summary = "All rice ontologies", description = "Get rice ontology terms (traits)")
    public ResponseEntity<List<Object>> getCOtermsTrait() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/COterms/trait/{coTerm}")
    @Operation(summary = "Ontology terms", description = "Get ontology term details")
    public ResponseEntity<Object> getCOterm(@PathVariable String coTerm) {
        return ResponseEntity.ok(Collections.emptyMap());
    }

    @GetMapping("/{varid}/COterms/trait/{coTerm}")
    @Operation(summary = "CO Term for variety", description = "Get CO term value for a specific variety")
    public ResponseEntity<Object> getVarietyCOterm(@PathVariable Long varid, @PathVariable String coTerm) {
        return ResponseEntity.ok(Collections.emptyMap());
    }

    @GetMapping("/all/COterms/trait/{coTerm}")
    @Operation(summary = "CO Term for all varieties", description = "Get CO term for all varieties")
    public ResponseEntity<Map<String, Object>> getAllVarietyCOterm(@PathVariable String coTerm) {
        return ResponseEntity.ok(Collections.emptyMap());
    }

    // Passport endpoints
    @GetMapping("/passports")
    @Operation(summary = "All passports", description = "Get all passport fields and IDs")
    public ResponseEntity<List<String>> getPassports() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/{varid}/passports")
    @Operation(summary = "Variety passports", description = "Get passport data for a variety")
    public ResponseEntity<Map<String, String>> getVarietyPassports(@PathVariable Long varid) {
        return ResponseEntity.ok(Collections.emptyMap());
    }

    @GetMapping("/passports/{passid}")
    @Operation(summary = "Passport data", description = "Get passport data by passport id")
    public ResponseEntity<Map<String, String>> getPassportById(@PathVariable String passid) {
        return ResponseEntity.ok(Collections.emptyMap());
    }

    @GetMapping("/datasets")
    @Operation(summary = "Get varieties by datasets", description = "Get varieties that belong to one of the provided datasets (comma-separated). Default dataset=3k if none provided")
    public ResponseEntity<List<VarietyDTO>> getByDatasets(
            @RequestParam(name = "datasets", required = false) String datasets,
            @RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        List<String> dsList;
        if (datasets == null || datasets.isBlank()) {
            dsList = Arrays.asList("3k").stream().map(String::toUpperCase).collect(Collectors.toList());
        } else {
            dsList = Arrays.stream(datasets.split(",")).map(String::trim).filter(s -> !s.isEmpty()).map(String::toUpperCase).collect(Collectors.toList());
        }
        return ResponseEntity.ok(allstockService.findAllByDatasets(dsList, limit));
    }

}