package org.irri.snpseek.service;

import org.irri.snpseek.DTO.PhenotypeDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class PhenotypeService {

    public List<PhenotypeDTO> getAllPhenotypes() {
        return Collections.emptyList();
    }

    public Map<String, String> getPhenotypeForAllVarieties(String phenId) {
        return new HashMap<>();
    }

    public Map<String, String> getAllPhenotypesForVariety(Long varietyId) {
        return new HashMap<>();
    }

    public String getVarietyPhenotype(Long varietyId, String phenId) {
        return "";
    }
}
