package org.irri.snpseek.controller;

import java.util.List;

import org.irri.snpseek.DTO.StockDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.irri.snpseek.service.StockService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/stocks")
@Tag(name = "Stock", description = "API's to query Stock related data")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    @Operation(summary = "All Stocks", description = "Gets all Stocks in the database")
    public ResponseEntity<List<StockDTO>> getStocks(@RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        if (limit > 0) {
            return ResponseEntity.ok(stockService.getAllStocks(limit));
        }
        return ResponseEntity.ok(stockService.getAllStocks());
    }
    
   
    @GetMapping("/{id}")
    @Operation(summary = "Stock details", description = "Gets stock details using stock id")
    public ResponseEntity<StockDTO> getStocksById(
            @Parameter(description = "Stock ID") @PathVariable Long id) {
        return ResponseEntity.ok(stockService.getVarietyById(id.intValue()));
    }
    
    @GetMapping("/organismId/{id}")
    @Operation(summary = "Stock List", description = "Gets List of Stocks by organism id. e.g. 9 for Japonica Nipponbare")
    public ResponseEntity<List<StockDTO>> getStocksByOrganismId(
            @Parameter(description = "Organism ID") @PathVariable Long id,
            @RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
        System.out.println("Getting stock with Organism ID: " + id + ", limit=" + limit);
        if (limit > 0) {
            return ResponseEntity.ok(stockService.getStocksByOrganismId(id.intValue(), limit));
        }
        return ResponseEntity.ok(stockService.getStocksByOrganismId(id.intValue()));
    }

//    @GetMapping("/name")
//    @Operation(summary = "Variety details", description = "Gets list of variety names")
//    public ResponseEntity<List<String>> getStocksNames() {
//        return ResponseEntity.ok(stockService.getAllVarietyNames());
//    }
//
//    @GetMapping("/namelike/{name}")
//    @Operation(summary = "Variety names like", description = "Gets all varieties with names using wildcard *name*")
//    public ResponseEntity<List<VarietyDTO>> getStocksNameLike(
//            @Parameter(description = "Name pattern") @PathVariable String name) {
//        return ResponseEntity.ok(stockService.getStocksByNameLike(name));
//    }
}