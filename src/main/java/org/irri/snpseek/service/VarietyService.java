package org.irri.snpseek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.irri.snpseek.DTO.VarietyDTO;
import org.irri.snpseek.entity.Variety;
import org.irri.snpseek.repository.VarietyRepository;
import org.springframework.stereotype.Service;

@Service
public class VarietyService {
    private final VarietyRepository varietyRepository;

    public VarietyService(VarietyRepository varietyRepository) {
        this.varietyRepository = varietyRepository;
    }

    public List<VarietyDTO> getAllVarieties() {
        return varietyRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public VarietyDTO getVarietyById(Long id) {
        Variety variety = varietyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variety not found: " + id));
        return convertToDTO(variety);
    }

    public List<VarietyDTO> getVarietiesBySubpopulation(String subpop) {
        return varietyRepository.findBySubpopulation(subpop).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<VarietyDTO> getVarietiesByCountry(String country) {
        return varietyRepository.findByCountry(country).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<String> getAllSubpopulations() {
        return varietyRepository.findAll().stream()
                .map(Variety::getSubpopulation)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getAllCountries() {
        return varietyRepository.findAll().stream()
                .map(Variety::getCountry)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getAllVarietyNames() {
        return varietyRepository.findAll().stream()
                .map(Variety::getName)
                .collect(Collectors.toList());
    }

    public List<VarietyDTO> getVarietiesByNameLike(String name) {
        return varietyRepository.findByNameContainingIgnoreCase(name).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private VarietyDTO convertToDTO(Variety variety) {
        VarietyDTO dto = new VarietyDTO();
        dto.setId(variety.getVarietyId());
        dto.setName(variety.getName());
        dto.setSubpopulation(variety.getSubpopulation());
        dto.setCountry(variety.getCountry());
        return dto;
    }
}
