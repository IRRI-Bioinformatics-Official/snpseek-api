package com.example.brapi.controller;

import com.example.brapi.model.BrapiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/serverinfo")
@Tag(name = "Server Info", description = "BrAPI Server Information - Get details about this BrAPI server")
public class ServerInfoController {

    @GetMapping
    @Operation(
        summary = "Get Server Information",
        description = "Returns information about the BrAPI server, including available endpoints and server metadata"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved server information")
    })
    
    public ResponseEntity<BrapiResponse<Map<String, Object>>> getServerInfo() {
        Map<String, Object> serverInfo = new HashMap<>();
        serverInfo.put("contactEmail", "admin@example.com");
        serverInfo.put("documentationURL", "https://brapi.org/specification");
        serverInfo.put("location", "Philippines");
        serverInfo.put("organizationName", "Example Organization");
        serverInfo.put("organizationURL", "https://example.com");
        serverInfo.put("serverDescription", "BrAPI Spring Boot Implementation");
        serverInfo.put("serverName", "BrAPI Server");
        
        List<Map<String, Object>> calls = new ArrayList<>();
        
        Map<String, Object> studiesCall = new HashMap<>();
        studiesCall.put("service", "studies");
        studiesCall.put("methods", Arrays.asList("GET", "POST"));
        studiesCall.put("versions", List.of("2.0", "2.1"));
        calls.add(studiesCall);
        
        Map<String, Object> serverInfoCall = new HashMap<>();
        serverInfoCall.put("service", "serverinfo");
        serverInfoCall.put("methods", List.of("GET"));
        serverInfoCall.put("versions", List.of("2.0", "2.1"));
        calls.add(serverInfoCall);
        
        serverInfo.put("calls", calls);

        BrapiResponse<Map<String, Object>> response = new BrapiResponse<>(serverInfo);
        return ResponseEntity.ok(response);
    }
}