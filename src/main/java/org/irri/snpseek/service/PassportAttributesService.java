package org.irri.snpseek.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.irri.snpseek.DTO.PassportAttributesDTO;
import org.irri.snpseek.entity.VCvPassportByDataset;
import org.irri.snpseek.repository.PassportAttributesRepository;
import org.springframework.stereotype.Service;

@Service
public class PassportAttributesService {
    private final PassportAttributesRepository repository;

    public PassportAttributesService(PassportAttributesRepository repository) {
        this.repository = repository;
    }

    public List<PassportAttributesDTO> getByDataset(String dataset) {
        return repository.findByDataset(dataset).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PassportAttributesDTO getByCvTermIdAndDataset(BigDecimal cvTermId, String dataset) {
        VCvPassportByDataset entity = repository.findByCvTermIdAndDataset(cvTermId, dataset);
        return entity == null ? null : toDTO(entity);
    }

    public List<PassportAttributesDTO> searchByName(String q, String dataset) {
        return repository.findByNameContainingIgnoreCaseAndDataset(q, dataset).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PassportAttributesDTO> searchByDefinition(String q, String dataset) {
        return repository.findByDefinitionContainingIgnoreCaseAndDataset(q, dataset).stream().map(this::toDTO).collect(Collectors.toList());
    }

    private PassportAttributesDTO toDTO(VCvPassportByDataset e) {
        PassportAttributesDTO dto = new PassportAttributesDTO();
        dto.setCvTermId(e.getCvTermId());
        dto.setName(e.getName());
        dto.setDefinition(e.getDefinition());
        dto.setDataset(e.getDataset());
        return dto;
    }
}
