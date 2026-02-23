package org.irri.snpseek.controller;

import java.util.List;

import org.irri.snpseek.DTO.VGeneDTO;
import org.irri.snpseek.service.VGeneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/vgene")
@Tag(name = "Genes", 
description = "API for accessing gene annotations and genomic coordinates")
public class VGeneController {
    private final VGeneService vGeneService;

    public VGeneController(VGeneService vGeneService) {
        this.vGeneService = vGeneService;
    }

    @GetMapping
    @Operation(summary = "All VGenes", description = "Gets list of all Genes. Optional query params: limit (max number of rows), offset (row offset).")
    public ResponseEntity<List<VGeneDTO>> getAll(
            @Parameter(description = "Maximum number of results to return") @RequestParam(required = true) Integer limit,
            @Parameter(description = "Row offset for paging") @RequestParam(required = false) Integer offset) {
        return ResponseEntity.ok(vGeneService.getAllVGenes(limit, offset));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Gene by id", description = "Get Gene details by gene id")
    public ResponseEntity<VGeneDTO> getById(@Parameter(description = "Gene ID") @PathVariable Integer id) {
        return ResponseEntity.ok(vGeneService.getVGeneById(id));
    }

    @GetMapping("/search")
    @Operation(summary = "Search by name", description = "Search Gene by name fragment. Optional params: limit, offset.")
    public ResponseEntity<List<VGeneDTO>> search(
            @RequestParam String geneName,
            @Parameter(description = "Maximum number of results to return") @RequestParam(required = false) Integer limit,
            @Parameter(description = "Row offset for paging") @RequestParam(required = false) Integer offset) {
        return ResponseEntity.ok(vGeneService.searchByName(geneName, limit, offset));
    }

    @GetMapping("/organism/{organismId}")
    @Operation(summary = "By organism", description = "Get Genes by organism id")
    public ResponseEntity<List<VGeneDTO>> byOrganism(@PathVariable Integer organismId,
			@Parameter(description = "Maximum number of results to return") @RequestParam(required = false) Integer limit,
			@Parameter(description = "Row offset for paging") @RequestParam(required = false) Integer offset) {
        return ResponseEntity.ok(vGeneService.getByOrganism(organismId, limit, offset));
    }

//    @PostMapping
//    @Operation(summary = "Create or update VGene", description = "Create or update VGene record")
//    public ResponseEntity<VGeneDTO> createOrUpdate(@RequestBody VGeneDTO dto) {
//        VGeneDTO saved = vGeneService.save(dto);
//        return ResponseEntity.ok(saved);
//    }
//
//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Gene", description = "Delete Gene by id")
//    public ResponseEntity<Void> delete(@PathVariable Integer id) {
//        vGeneService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}