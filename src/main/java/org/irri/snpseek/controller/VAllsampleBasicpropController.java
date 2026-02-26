package org.irri.snpseek.controller;

import java.math.BigDecimal;
import java.util.List;

import org.irri.snpseek.DTO.VAllsampleBasicpropDTO;
import org.irri.snpseek.service.VAllsampleBasicpropService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
