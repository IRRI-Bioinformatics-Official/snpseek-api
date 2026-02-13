package org.irri.snpseek.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.irri.snpseek.DTO.ReferenceSequenceDTO;
import org.irri.snpseek.entity.VScaffoldsOrganism;
import org.irri.snpseek.repository.ReferenceSequenceRepository;
import org.springframework.stereotype.Service;

@Service
public class ReferenceSequenceService {
    private final ReferenceSequenceRepository referenceSequenceRepository;

    public ReferenceSequenceService(ReferenceSequenceRepository referenceSequenceRepository) {
        this.referenceSequenceRepository = referenceSequenceRepository;
    }

    public List<ReferenceSequenceDTO> getAllReferenceSequences() {
        return referenceSequenceRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ReferenceSequenceDTO getById(BigDecimal id) {
        return referenceSequenceRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public List<ReferenceSequenceDTO> findByOrganismId(BigDecimal organismId) {
        return referenceSequenceRepository.findByOrganismId(organismId).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<ReferenceSequenceDTO> findByOrganismIdAndTypeName(BigDecimal organismId, String typeName) {
        return referenceSequenceRepository.findByOrganismIdAndType(organismId, typeName).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<ReferenceSequenceDTO> findByNameLike(String name) {
        return referenceSequenceRepository.findByNameContainingIgnoreCase(name).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ReferenceSequenceDTO convertToDTO(VScaffoldsOrganism vScaffoldsOrganism) {
        ReferenceSequenceDTO dto = new ReferenceSequenceDTO();

        dto.setFeatureId(vScaffoldsOrganism.getFeatureId());
        dto.setName(vScaffoldsOrganism.getName());
        dto.setUniquename(vScaffoldsOrganism.getUniquename());
        dto.setSeqlen(vScaffoldsOrganism.getSeqlen());
        dto.setOrganismId(vScaffoldsOrganism.getOrganismId());
        dto.setCommonName(vScaffoldsOrganism.getCommonName());
        dto.setTypeId(vScaffoldsOrganism.getTypeId());
        dto.setType(vScaffoldsOrganism.getType());

        return dto;
    }

}