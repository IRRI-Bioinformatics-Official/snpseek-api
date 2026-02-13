package org.irri.snpseek.controller;

import java.math.BigDecimal;
import java.util.List;

import org.irri.snpseek.DTO.ReferenceSequenceDTO;
import org.irri.snpseek.service.ReferenceSequenceService;
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
@RequestMapping("/reference-sequence")
@Tag(name = "ReferenceSequence", description = "APIs to query reference sequence (feature) data")
public class ReferenceSequenceController {
    private final ReferenceSequenceService referenceSequenceService;

    public ReferenceSequenceController(ReferenceSequenceService referenceSequenceService) {
        this.referenceSequenceService = referenceSequenceService;
    }

    @GetMapping
    @Operation(summary = "All reference sequences", description = "Gets list of all reference sequences")
    public ResponseEntity<List<ReferenceSequenceDTO>> getAll() {
        return ResponseEntity.ok(referenceSequenceService.getAllReferenceSequences());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Reference sequence by id", description = "Get reference sequence details by feature id")
    public ResponseEntity<ReferenceSequenceDTO> getById(@Parameter(description = "Feature ID") @PathVariable BigDecimal id) {
        return ResponseEntity.ok(referenceSequenceService.getById(id));
    }

    @GetMapping("/organism/{organismId}")
    @Operation(summary = "Reference sequences by organism", description = "Get sequences for a given organism id")
    public ResponseEntity<List<ReferenceSequenceDTO>> getByOrganism(@PathVariable BigDecimal organismId) {
        return ResponseEntity.ok(referenceSequenceService.findByOrganismId(organismId));
    }
    
    @GetMapping("/organism/{organismId}/typeName/{type}")
    @Operation(summary = "Reference sequences by organism and type", description = "Get sequences for a given organism id and type")
    public ResponseEntity<List<ReferenceSequenceDTO>> getByOrganism(@PathVariable BigDecimal organismId, @PathVariable String type) {
        return ResponseEntity.ok(referenceSequenceService.findByOrganismIdAndTypeName(organismId, type));
    }

    @GetMapping("/search")
    @Operation(summary = "Search reference sequences by name", description = "Search sequences by name fragment")
    public ResponseEntity<List<ReferenceSequenceDTO>> searchByName(@RequestParam String q) {
        return ResponseEntity.ok(referenceSequenceService.findByNameLike(q));
    }
}