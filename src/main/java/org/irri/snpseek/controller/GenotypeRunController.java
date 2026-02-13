package org.irri.snpseek.controller;

import java.util.List;

import org.irri.snpseek.DTO.GenotypeRunDTO;
import org.irri.snpseek.service.GenotypeRunService;
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
@RequestMapping("/genotype-runs")
@Tag(name = "GenotypeRuns", description = "APIs to query genotype run metadata")
public class GenotypeRunController {
    private final GenotypeRunService genotypeRunService;

    public GenotypeRunController(GenotypeRunService genotypeRunService) {
        this.genotypeRunService = genotypeRunService;
    }

    @GetMapping
    @Operation(summary = "All genotype runs", description = "Gets list of all genotype runs")
    public ResponseEntity<List<GenotypeRunDTO>> getAll() {
        return ResponseEntity.ok(genotypeRunService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Genotype run by id", description = "Get genotype run details by id")
    public ResponseEntity<GenotypeRunDTO> getById(@Parameter(description = "Genotype Run ID") @PathVariable Integer id) {
        GenotypeRunDTO dto = genotypeRunService.getById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/by-dataset/{dataset}")
    @Operation(summary = "Genotype runs by dataset", description = "Get genotype runs for a given dataset name")
    public ResponseEntity<List<GenotypeRunDTO>> getByDataset(@PathVariable String dataset) {
        return ResponseEntity.ok(genotypeRunService.findByDataset(dataset));
    }

    @GetMapping("/by-variant-type")
    @Operation(summary = "Genotype runs by variant type", description = "Get genotype runs for a given variant type")
    public ResponseEntity<List<GenotypeRunDTO>> getByVariantType(@RequestParam String type) {
        return ResponseEntity.ok(genotypeRunService.findByVariantType(type));
    }
}
