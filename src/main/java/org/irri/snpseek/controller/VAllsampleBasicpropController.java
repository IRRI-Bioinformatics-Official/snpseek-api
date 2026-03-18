package org.irri.snpseek.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.irri.snpseek.DTO.VAllsampleBasicpropDTO;
import org.irri.snpseek.service.VAllsampleBasicpropService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * V_ALLSAMPLE_BASICPROP view contains basic properties of all samples, including stock sample id, dataset, and other related information. 
 * 
 * This controller provides API endpoints to access sample basic properties by dataset and stock sample id.
 * 
 * 
 **/
@RestController
@RequestMapping("/samples")
public class VAllsampleBasicpropController {

    private final VAllsampleBasicpropService service;

    public VAllsampleBasicpropController(VAllsampleBasicpropService service) {
        this.service = service;
    }

    @GetMapping("/by-datasets")
    public ResponseEntity<List<VAllsampleBasicpropDTO>> getByDatasets(@RequestParam(name = "datasets") List<String> datasets) {
        return ResponseEntity.ok(service.findByDatasets(datasets));
    }

    @GetMapping("/{stockSampleId}")
    public ResponseEntity<VAllsampleBasicpropDTO> getByStockSampleId(@PathVariable("stockSampleId") BigDecimal id) {
        VAllsampleBasicpropDTO dto = service.findByStockSampleId(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    // New: expose the named-query use-case: find by dataset IN and optional stockSampleId IN
    @GetMapping("/by-datasets-and-ids")
    public ResponseEntity<List<VAllsampleBasicpropDTO>> getByDatasetsAndIds(@RequestParam(name = "datasets") List<String> datasets,
                                                                            @RequestParam(name = "stockSampleIds", required = false) List<BigDecimal> stockSampleIds) {
        return ResponseEntity.ok(service.findByDatasetsAndSampleIds(datasets, stockSampleIds));
    }

    // New: accept a Set of dataset values only and call the DAO-named-query equivalent
    @GetMapping("/by-dataset-in")
    public ResponseEntity<List<VAllsampleBasicpropDTO>> getByDatasetIn(@RequestParam(name = "datasets") Set<String> datasets) {
        return ResponseEntity.ok(service.findVAllsampleBasicpropByDatasetIn(datasets));
    }
}