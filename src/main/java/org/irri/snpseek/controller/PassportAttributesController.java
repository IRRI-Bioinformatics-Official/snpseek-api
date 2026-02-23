package org.irri.snpseek.controller;

import java.math.BigDecimal;
import java.util.List;

import org.irri.snpseek.DTO.PassportAttributesDTO;
import org.irri.snpseek.service.PassportAttributesService;
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
@RequestMapping("/passport-attributes")
@Tag(name = "PassportAttributes", description = "API for controlled vocabulary terms used in germplasm passport data")
public class PassportAttributesController {
    private final PassportAttributesService passportAttributesService;

    public PassportAttributesController(PassportAttributesService passportAttributesService) {
        this.passportAttributesService = passportAttributesService;
    }

    @GetMapping("/dataset/{dataset}")
    @Operation(summary = "List passport CV terms for dataset", description = "Returns all passport CV terms for the given dataset")
    public ResponseEntity<List<PassportAttributesDTO>> getByDataset(@Parameter(description = "Dataset name") @PathVariable String dataset) {
        return ResponseEntity.ok(passportAttributesService.getByDataset(dataset));
    }

    @GetMapping("/{cvTermId}/{dataset}")
    @Operation(summary = "Get passport CV term by id and dataset", description = "Returns a passport CV term by cvTermId and dataset")
    public ResponseEntity<PassportAttributesDTO> getByCvTermIdAndDataset(
            @Parameter(description = "CV term id") @PathVariable BigDecimal cvTermId,
            @Parameter(description = "Dataset name") @PathVariable String dataset) {
        PassportAttributesDTO dto = passportAttributesService.getByCvTermIdAndDataset(cvTermId, dataset);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/search/name")
    @Operation(summary = "Search passport CV terms by name", description = "Search passport CV terms by name fragment within a dataset")
    public ResponseEntity<List<PassportAttributesDTO>> searchByName(
            @Parameter(description = "Query fragment") @RequestParam String q,
            @Parameter(description = "Dataset name") @RequestParam String dataset) {
        return ResponseEntity.ok(passportAttributesService.searchByName(q, dataset));
    }

    @GetMapping("/search/definition")
    @Operation(summary = "Search passport CV terms by definition", description = "Search passport CV terms by definition fragment within a dataset")
    public ResponseEntity<List<PassportAttributesDTO>> searchByDefinition(
            @Parameter(description = "Query fragment") @RequestParam String q,
            @Parameter(description = "Dataset name") @RequestParam String dataset) {
        return ResponseEntity.ok(passportAttributesService.searchByDefinition(q, dataset));
    }
}
