package org.irri.snpseek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.irri.snpseek.DTO.GenotypeRunDTO;
import org.irri.snpseek.entity.VGenotypeRun;
import org.irri.snpseek.repository.GenotypeRunRepository;
import org.springframework.stereotype.Service;

@Service
public class GenotypeRunService {
    private final GenotypeRunRepository repository;

    public GenotypeRunService(GenotypeRunRepository repository) {
        this.repository = repository;
    }

    public List<GenotypeRunDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public GenotypeRunDTO getById(Integer id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    public List<GenotypeRunDTO> findByDataset(String dataset) {
        return repository.findByDataset(dataset).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<GenotypeRunDTO> findByVariantType(String variantType) {
        return repository.findByVariantType(variantType).stream().map(this::toDTO).collect(Collectors.toList());
    }

    private GenotypeRunDTO toDTO(VGenotypeRun e) {
        GenotypeRunDTO dto = new GenotypeRunDTO();
        dto.setGenotypeRunId(e.getGenotypeRunId());
        dto.setDatePerformed(e.getDatePerformed());
        dto.setDataLocation(e.getDataLocation());
        dto.setPlatformId(e.getPlatformId());
        dto.setVariantsetId(e.getVariantsetId());
        dto.setVariantset(e.getVariantset());
        dto.setVsDescription(e.getVsDescription());
        dto.setVariantTypeId(e.getVariantTypeId());
        dto.setDatasetId(e.getDatasetId());
        dto.setDataset(e.getDataset());
        dto.setCommonName(e.getCommonname());
        dto.setDsDescription(e.getDsDescription());
        dto.setMethod(e.getMethod());
        dto.setVariantType(e.getVariantType());
        return dto;
    }
}
