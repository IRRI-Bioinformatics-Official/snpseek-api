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
@RequestMapping("/genotypeRun")
@Tag(name = "GenotypeRuns",  description = "API for genotyping experiment runs and variant calling datasets")
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

    // Accept both /dataset and /dataset/{dataset} so callers may omit the path variable and rely on default
    @GetMapping({"/dataset/{dataset}", "/dataset"})
    @Operation(summary = "Genotype runs by dataset", description = "Get genotype runs for a given dataset name (default 3k)")
    public ResponseEntity<List<GenotypeRunDTO>> getByDataset(@PathVariable(required = false) String dataset ,
            @RequestParam(name = "variantType", required = false, defaultValue = "SNP") String variantType,
            @RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        String ds = (dataset == null || dataset.isEmpty()) ? "3k" : dataset;
        if (limit > 0) {
            return ResponseEntity.ok(genotypeRunService.findByDataset(ds).stream().filter(r -> variantType == null || variantType.isEmpty() || (r.getVariantType() != null && r.getVariantType().equalsIgnoreCase(variantType))).toList());
        }
        return ResponseEntity.ok(genotypeRunService.findByDataset(ds).stream().filter(r -> variantType == null || variantType.isEmpty() || (r.getVariantType() != null && r.getVariantType().equalsIgnoreCase(variantType))).toList());
    }
    
    @GetMapping("/organism/{organismName}")
    @Operation(summary = "Genotype runs by Organism Name", description = "Get genotype runs for a given common name (default Japonica Nipponbare)")
    public ResponseEntity<List<GenotypeRunDTO>> getByOrganismName(@PathVariable(required = false) String organismName,
            @RequestParam(name = "dataset", required = false, defaultValue = "3k") String dataset,
            @RequestParam(name = "variantType", required = false, defaultValue = "SNP") String variantType,
            @RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        String org = (organismName == null || organismName.isEmpty()) ? "Japonica Nipponbare" : organismName;
        String ds = (dataset == null || dataset.isEmpty()) ? "3k" : dataset;
        if (limit > 0) {
            return ResponseEntity.ok(genotypeRunService.findByCommonNameAndDataset(org, ds, variantType, limit));
        }
        return ResponseEntity.ok(genotypeRunService.findByCommonNameAndDataset(org, ds, variantType));
    }

    @GetMapping("/organism/{organismName}/dataset/{dataset}")
    @Operation(summary = "Genotype runs by organism and dataset", description = "Get genotype runs filtered by organism common name and dataset")
    public ResponseEntity<List<GenotypeRunDTO>> getByOrganismAndDataset(@PathVariable String organismName,
            @PathVariable String dataset,
            @RequestParam(name = "variantType", required = false, defaultValue = "SNP") String variantType,
            @RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        String org = (organismName == null || organismName.isEmpty()) ? "Japonica Nipponbare" : organismName;
        String ds = (dataset == null || dataset.isEmpty()) ? "3k" : dataset;
        if (limit > 0) {
            return ResponseEntity.ok(genotypeRunService.findByCommonNameAndDataset(org, ds, variantType, limit));
        }
        return ResponseEntity.ok(genotypeRunService.findByCommonNameAndDataset(org, ds, variantType));
    }

    @GetMapping("/variantset/{variantset}/dataset/{dataset}")
    @Operation(summary = "Genotype runs by variantset and dataset", description = "Get genotype runs filtered by variantset and dataset")
    public ResponseEntity<List<GenotypeRunDTO>> getByVariantsetAndDataset(@PathVariable(required = false) String variantset,
            @PathVariable(required = false) String dataset,
            @RequestParam(name = "variantType", required = false, defaultValue = "SNP") String variantType,
            @RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        String vs = (variantset == null || variantset.isEmpty()) ? "3kfiltered" : variantset;
        String ds = (dataset == null || dataset.isEmpty()) ? "3k" : dataset;
        if (limit > 0) {
            return ResponseEntity.ok(genotypeRunService.findByVariantsetAndDataset(vs, ds, variantType, limit));
        }
        return ResponseEntity.ok(genotypeRunService.findByVariantsetAndDataset(vs, ds, variantType));
    }

    @GetMapping("/variantset/{variantset}")
    @Operation(summary = "Genotype runs by variantset", description = "Get genotype runs filtered by variantset")
    public ResponseEntity<List<GenotypeRunDTO>> getByVariantset(@PathVariable(required = false) String variantset,
            @RequestParam(name = "variantType", required = false, defaultValue = "SNP") String variantType,
            @RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        String vs = (variantset == null || variantset.isEmpty()) ? "3kfiltered" : variantset;
        if (limit > 0) {
            return ResponseEntity.ok(genotypeRunService.findByVariantset(vs, variantType, limit));
        }
        return ResponseEntity.ok(genotypeRunService.findByVariantset(vs, variantType));
    }

    @GetMapping("/variantType")
    @Operation(summary = "Genotype runs by variant type", description = "Get genotype runs for a given variant type")
    public ResponseEntity<List<GenotypeRunDTO>> getByVariantType(@RequestParam(name = "variantType", required = false, defaultValue = "SNP") String variantType,
            @RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        if (limit > 0) {
            // no direct pageable repository by variantType, fallback to service findByVariantType and limit
            List<GenotypeRunDTO> results = genotypeRunService.findByVariantType(variantType);
            return ResponseEntity.ok(results.stream().limit(limit).toList());
        }
        return ResponseEntity.ok(genotypeRunService.findByVariantType(variantType));
    }

//    @PutMapping("/{id}/commonName")
//    @Operation(summary = "Update common name", description = "Update the common_name (organism) for a genotype run")
//    public ResponseEntity<GenotypeRunDTO> updateCommonName(@PathVariable Integer id,
//            @RequestBody String newCommonName) {
//        GenotypeRunDTO updated = genotypeRunService.updateCommonName(id, newCommonName);
//        if (updated == null) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(updated);
//    }
}
