package org.irri.snpseek.controller;

import java.util.List;

import org.irri.snpseek.DTO.OrganismDTO;
import org.irri.snpseek.service.OrganismService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/organism")
@Tag(name = "Organism", description = "API's to query Organism related data")
public class OrganismController {
	
    private final OrganismService organismService;

    public OrganismController(OrganismService organismService) {
        this.organismService = organismService;
    }

    @GetMapping
    @Operation(summary = "All Organism", description = "Gets List of all Organism")
    public ResponseEntity<List<OrganismDTO>> getVarieties() {
        return ResponseEntity.ok(organismService.getAllOrganism());
    }
    
   
    @GetMapping("/{id}")
    @Operation(summary = "Organism details", description = "Gets organism details using organism id")
    public ResponseEntity<OrganismDTO> getVarietiesById(
            @Parameter(description = "Organism ID") @PathVariable Long id) {
    	System.out.println("Getting Organism with ID: " + id);
        return ResponseEntity.ok(organismService.getOrganismById(id.intValue()));
    }

 
}
