package org.irri.snpseek.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.irri.snpseek.DTO.FeatureDTO;
import org.irri.snpseek.entity.Feature;
import org.irri.snpseek.entity.Organism;
import org.irri.snpseek.repository.FeatureRepository;
import org.irri.snpseek.repository.OrganismRepository;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {
    private final FeatureRepository featureRepository;
    private final OrganismRepository organismRepository;

    public FeatureService(FeatureRepository featureRepository, OrganismRepository organismRepository) {
        this.featureRepository = featureRepository;
        this.organismRepository = organismRepository;
    }

    public List<FeatureDTO> getAllFeatures() {
        return featureRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public FeatureDTO getFeatureById(Integer id) {
        Feature feature = featureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feature not found with id: " + id));
        return convertToDTO(feature);
    }

    public List<FeatureDTO> getFeaturesByOrganismId(Integer organismId) {
        return featureRepository.findByOrganismId(organismId).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // new helper to resolve organismId by common name (case-insensitive)
    private Integer resolveOrganismIdByName(String organismName) {
        if (organismName == null) return null;
        Optional<Organism> opt = organismRepository.findByCommonNameIgnoreCase(organismName);
        if (opt.isPresent()) {
            Organism o = opt.get();
            return o.getOrganismId() != null ? o.getOrganismId().intValue() : null;
        }
        return null;
    }

    public List<FeatureDTO> findByOrganismIdAndNameOrUniquename(Integer organismId, String q) {
        if (q == null) {
            return getFeaturesByOrganismId(organismId);
        }
        String pattern = q;
        if (!pattern.contains("%")) {
            pattern = "%" + pattern + "%";
        }
        return featureRepository.findByOrganismIdAndUniqueNameOrName(organismId, pattern)
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<FeatureDTO> findByOrganismNameAndNameOrUniquename(String organismName, String q) {
        Integer id = resolveOrganismIdByName(organismName);
        if (id == null) {
            return java.util.Collections.emptyList();
        }
        return findByOrganismIdAndNameOrUniquename(id, q);
    }

    private FeatureDTO convertToDTO(Feature feature) {
        FeatureDTO dto = new FeatureDTO();
        dto.setFeatureId(feature.getFeatureId() != null ? BigDecimal.valueOf(feature.getFeatureId()) : null);
        dto.setName(feature.getName());
        dto.setUniquename(feature.getUniquename());
        dto.setSeqlen(feature.getSeqlen());
        dto.setOrganismId(feature.getOrganismId() != null ? BigDecimal.valueOf(feature.getOrganismId()) : null);
        dto.setTypeId(feature.getTypeId());
        dto.setMd5checksum(feature.getMd5checksum());
        dto.setIsObsolete(feature.getIsObsolete());
        return dto;
    }
}