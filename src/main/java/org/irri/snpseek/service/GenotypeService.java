package org.irri.snpseek.service;

import org.irri.snpseek.DTO.GenotypeRequest;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class GenotypeService {

    public Map<String, Object> getGenotypeTable(GenotypeRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "Genotype table - Implementation needed");
        result.put("request", request);
        return result;
    }
}
