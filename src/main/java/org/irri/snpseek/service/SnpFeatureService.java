package org.irri.snpseek.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.irri.snpseek.DTO.SnpRefPosIndex;
import org.irri.snpseek.repository.SnpFeatureRepository;
import org.springframework.stereotype.Service;

@Service
public class SnpFeatureService {

    private final SnpFeatureRepository snpFeatureRepository;

    public SnpFeatureService(SnpFeatureRepository snpFeatureRepository) {
        this.snpFeatureRepository = snpFeatureRepository;
    }

    public List<SnpRefPosIndex> getSnpRefPosIndex(Long organismId, Long srcfeatureId, Integer chromosome, Long startPos, Long endPos, String variantsetNamesCsv) {
        List<String> variantsetNames = Arrays.stream((variantsetNamesCsv == null) ? new String[0] : variantsetNamesCsv.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        if (variantsetNames.isEmpty()) {
            return List.of();
        }
        return snpFeatureRepository.findSnpRefPosIndex(organismId, srcfeatureId, chromosome, startPos, endPos, variantsetNames);
    }
}
