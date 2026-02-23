package org.irri.snpseek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.irri.snpseek.DTO.GenotypeRunDTO;
import org.irri.snpseek.entity.VGenotypeRun;
import org.irri.snpseek.repository.GenotypeRunRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    public List<GenotypeRunDTO> findByCommonName(String organismName) {
        return repository.findByCommonnameContainingIgnoreCase(organismName).stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Use case 1: genotype runs by organism (common_name) and dataset, with optional variantType filter
    public List<GenotypeRunDTO> findByCommonNameAndDataset(String organismName, String dataset, String variantType) {
        return repository.findByCommonnameContainingIgnoreCaseAndDataset(organismName, dataset).stream()
                .filter(r -> variantType == null || variantType.isEmpty() || (r.getVariantType() != null && r.getVariantType().equalsIgnoreCase(variantType)))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<GenotypeRunDTO> findByCommonNameAndDataset(String organismName, String dataset, String variantType, int limit) {
        if (limit > 0) {
            Pageable p = PageRequest.of(0, limit);
            return repository.findByCommonnameContainingIgnoreCaseAndDataset(organismName, dataset, p).stream()
                    .filter(r -> variantType == null || variantType.isEmpty() || (r.getVariantType() != null && r.getVariantType().equalsIgnoreCase(variantType)))
                    .map(this::toDTO)
                    .collect(Collectors.toList());
        }
        return findByCommonNameAndDataset(organismName, dataset, variantType);
    }

    // Use case 2: genotype runs by variantset and dataset
    public List<GenotypeRunDTO> findByVariantsetAndDataset(String variantset, String dataset, String variantType) {
        return repository.findByVariantsetAndDataset(variantset, dataset).stream()
                .filter(r -> variantType == null || variantType.isEmpty() || (r.getVariantType() != null && r.getVariantType().equalsIgnoreCase(variantType)))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<GenotypeRunDTO> findByVariantsetAndDataset(String variantset, String dataset, String variantType, int limit) {
        if (limit > 0) {
            Pageable p = PageRequest.of(0, limit);
            return repository.findByVariantsetAndDataset(variantset, dataset, p).stream()
                    .filter(r -> variantType == null || variantType.isEmpty() || (r.getVariantType() != null && r.getVariantType().equalsIgnoreCase(variantType)))
                    .map(this::toDTO)
                    .collect(Collectors.toList());
        }
        return findByVariantsetAndDataset(variantset, dataset, variantType);
    }

    // Use case 3: genotype runs by variantset
    public List<GenotypeRunDTO> findByVariantset(String variantset, String variantType) {
        return repository.findByVariantsetContainingIgnoreCase(variantset).stream()
                .filter(r -> variantType == null || variantType.isEmpty() || (r.getVariantType() != null && r.getVariantType().equalsIgnoreCase(variantType)))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<GenotypeRunDTO> findByVariantset(String variantset, String variantType, int limit) {
        if (limit > 0) {
            Pageable p = PageRequest.of(0, limit);
            return repository.findByVariantsetContainingIgnoreCase(variantset, p).stream()
                    .filter(r -> variantType == null || variantType.isEmpty() || (r.getVariantType() != null && r.getVariantType().equalsIgnoreCase(variantType)))
                    .map(this::toDTO)
                    .collect(Collectors.toList());
        }
        return findByVariantset(variantset, variantType);
    }

    @Transactional
    public GenotypeRunDTO updateCommonName(Integer genotypeRunId, String newCommonName) {
        return repository.findById(genotypeRunId).map(r -> {
            r.setCommonname(newCommonName);
            VGenotypeRun saved = repository.save(r);
            return toDTO(saved);
        }).orElse(null);
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