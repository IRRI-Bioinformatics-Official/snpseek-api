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
    @Operation(summary = "All varieties", description = "Gets all varieties")
    public ResponseEntity<List<VarietyDTO>> getVarieties() {
        return ResponseEntity.ok(varietyService.getAllVarieties());
    }
    
   
    @GetMapping("/{id}")
    @Operation(summary = "Variety details", description = "Gets variety details using variety id")
    public ResponseEntity<VarietyDTO> getVarietiesById(
            @Parameter(description = "Variety ID") @PathVariable Long id) {
    	return ResponseEntity.ok(varietyService.getVarietyById(id.intValue()));
    }
    
    @GetMapping("/organismId/{id}")
    @Operation(summary = "Variety List", description = "Gets List of Varieties by organism id. e.g. 9 for Japonica Nipponbare")
    public ResponseEntity<List<VarietyDTO>> getVarietiesByOrganismId(
            @Parameter(description = "Organism ID") @PathVariable Long id) {
    	System.out.println("Getting variety with Organism ID: " + id);
        return ResponseEntity.ok(varietyService.getVarietiesByOrganismId(id.intValue()));
    }

//    @GetMapping("/name")
//    @Operation(summary = "Variety details", description = "Gets list of variety names")
//    public ResponseEntity<List<String>> getVarietiesNames() {
//        return ResponseEntity.ok(varietyService.getAllVarietyNames());
//    }
//
//    @GetMapping("/namelike/{name}")
//    @Operation(summary = "Variety names like", description = "Gets all varieties with names using wildcard *name*")
//    public ResponseEntity<List<VarietyDTO>> getVarietiesNameLike(
//            @Parameter(description = "Name pattern") @PathVariable String name) {
//        return ResponseEntity.ok(varietyService.getVarietiesByNameLike(name));
//    }
}
