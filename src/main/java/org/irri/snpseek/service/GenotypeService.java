package org.irri.snpseek.service;

import org.irri.snpseek.DTO.GenotypeRequest;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class GenotypeService {

    public Map<String, Object> getGenotypeTable(GenotypeRequest request) {
        Map<String, Object> result = new HashMap<>();

        // parse set pairs (dataset:variantset)
        Set<String> datasets = new HashSet<>();
        Set<String> variantsets = new HashSet<>();
        if (request.getSet() != null && !request.getSet().trim().isEmpty()) {
            String[] pairs = request.getSet().split(",");
            for (String pair : pairs) {
                String t = pair.trim();
                if (t.isEmpty()) continue;
                int idx = t.indexOf(":");
                if (idx > -1) {
                    String ds = t.substring(0, idx).trim();
                    String vs = t.substring(idx + 1).trim();
                    if (!ds.isEmpty()) datasets.add(ds);
                    if (!vs.isEmpty()) variantsets.add(vs);
                } else {
                    datasets.add(t);
                }
            }
        }

        // parse varid into collection of BigDecimal
        Collection<BigDecimal> varIds = null;
        if (request.getVarid() != null && !"all".equals(request.getVarid())) {
            String[] parts = request.getVarid().split(",");
            varIds = new HashSet<>();
            for (String p : parts) {
                String v = p.trim();
                if (v.isEmpty()) continue;
                varIds.add(BigDecimal.valueOf(Long.parseLong(v)));
            }
        }

        // parse poslist
        Collection<BigDecimal> poslist = null;
        if (request.getPoslist() != null && !request.getPoslist().trim().isEmpty()) {
            String[] parts = request.getPoslist().split(",");
            poslist = new ArrayList<>();
            for (String p : parts) {
                String v = p.trim();
                if (v.isEmpty()) continue;
                poslist.add(BigDecimal.valueOf(Long.parseLong(v)));
            }
        }

        result.put("datasets", datasets);
        result.put("variantsets", variantsets);
        result.put("varIds", varIds == null ? Collections.emptyList() : varIds);
        result.put("posList", poslist == null ? Collections.emptyList() : poslist);
        result.put("request", request);
        result.put("message", "Parsed parameters (genotype execution not implemented yet)");
        return result;
    }
}