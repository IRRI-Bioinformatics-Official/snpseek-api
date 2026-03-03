package org.irri.snpseek.controller;

import java.util.List;

import org.irri.snpseek.DTO.FeatureDTO;
import org.irri.snpseek.service.FeatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/feature")
@Tag(name = "Feature", description = "API's to query Feature related data")
public class FeatureController {
    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping
    @Operation(summary = "All Features", description = "Gets List of all Features")
    public ResponseEntity<List<FeatureDTO>> getFeatures(@RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        // Note: limit parameter currently ignored; repository/service can be extended with paging
        return ResponseEntity.ok(featureService.getAllFeatures());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Feature details", description = "Gets feature details using feature id")
    public ResponseEntity<FeatureDTO> getFeatureById(
            @Parameter(description = "Feature ID") @PathVariable Integer id) {
        return ResponseEntity.ok(featureService.getFeatureById(id));
    }

    @GetMapping("/organism/{id}")
    @Operation(summary = "Features by organism", description = "Gets List of Features by organism id")
    public ResponseEntity<List<FeatureDTO>> getByOrganismId(
            @Parameter(description = "Organism ID") @PathVariable Integer id) {
        return ResponseEntity.ok(featureService.getFeaturesByOrganismId(id));
    }

    @GetMapping("/search")
    @Operation(summary = "Search Features", description = "Search Features by organismId or organismName and name or uniquename (case-insensitive)")
    public ResponseEntity<List<FeatureDTO>> searchByOrganismAndName(
            @Parameter(description = "Organism ID") @RequestParam(name = "organismId", required = false) Integer organismId,
            @Parameter(description = "Organism common name") @RequestParam(name = "organismName", required = false) String organismName,
            @Parameter(description = "Query string to search name or uniquename") @RequestParam(name = "q", required = false) String name) {
        if (organismId != null) {
            return ResponseEntity.ok(featureService.findByOrganismIdAndNameOrUniquename(organismId, name));
        }
        if (organismName != null && !organismName.isEmpty()) {
            return ResponseEntity.ok(featureService.findByOrganismNameAndNameOrUniquename(organismName, name));
        }
        // neither provided -> bad request
        return ResponseEntity.badRequest().build();
    }
}