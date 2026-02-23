package org.irri.snpseek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.irri.snpseek.DTO.VarietyDTO;
import org.irri.snpseek.entity.VAllstockBasicprop;
import org.irri.snpseek.repository.VAllstockBasicpropRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VAllstockBasicpropService {
    private final VAllstockBasicpropRepository repository;

    public VAllstockBasicpropService(VAllstockBasicpropRepository repository) {
        this.repository = repository;
    }

    public List<VarietyDTO> findAllByDatasets(List<String> datasets) {
        return repository.findAllByDatasets(datasets).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<VarietyDTO> findAllByDatasets(List<String> datasets, int limit) {
        if (limit > 0) {
            Pageable p = PageRequest.of(0, limit);
            return repository.findAllByDatasets(datasets, p).stream().map(this::toDTO).collect(Collectors.toList());
        }
        return findAllByDatasets(datasets);
    }

    // Updated: use repository.findAll(Pageable) instead of direct EntityManager named query
    public List<VarietyDTO> findAllVAllstockBasicprops(int limit) {
        if (limit > 0) {
            Pageable p = PageRequest.of(0, limit);
            return repository.findAll(p).stream().map(this::toDTO).collect(Collectors.toList());
        }
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private VarietyDTO toDTO(VAllstockBasicprop e) {
        VarietyDTO dto = new VarietyDTO();
        dto.setStockSampleId(e.getStockSampleId());
        dto.setAllStockIdId(e.getallStockIdId());
        dto.setName(e.getName());
        dto.setIrisUniqueId(e.getIrisUniqueId());
        dto.setOriCountry(e.getOriCountry());
        dto.setSubpopulation(e.getSubpopulation());
        dto.setBoxCode(e.getBoxCode());
        dto.setGsAccession(e.getAccession());
        dto.setDataset(e.getDataset());
        return dto;
    }
}