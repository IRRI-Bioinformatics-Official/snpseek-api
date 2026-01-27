package org.irri.snpseek.service;

import org.irri.snpseek.DTO.PhenotypeDTO;
import org.irri.snpseek.entity.Phenotype;
import org.irri.snpseek.entity.VarietyPhenotype;
import org.irri.snpseek.repository.PhenotypeRepository;
import org.irri.snpseek.repository.VarietyPhenotypeRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PhenotypeService {
    private final PhenotypeRepository phenotypeRepository;
    private final VarietyPhenotypeRepository varietyPhenotypeRepository;

    public PhenotypeService(PhenotypeRepository phenotypeRepository,
                            VarietyPhenotypeRepository varietyPhenotypeRepository) {
        this.phenotypeRepository = phenotypeRepository;
        this.varietyPhenotypeRepository = varietyPhenotypeRepository;
    }

    public List<PhenotypeDTO> getAllPhenotypes() {
        return phenotypeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Map<String, String> getPhenotypeForAllVarieties(String phenId) {
        List<VarietyPhenotype> data = varietyPhenotypeRepository.findByPhenId(phenId);
        Map<String, String> result = new HashMap<>();
        data.forEach(vp -> result.put(vp.getVarietyId().toString(), vp.getValue()));
        return result;
    }

    public Map<String, String> getAllPhenotypesForVariety(Long varietyId) {
        List<VarietyPhenotype> data = varietyPhenotypeRepository.findByVarietyId(varietyId);
        Map<String, String> result = new HashMap<>();
        data.forEach(vp -> result.put(vp.getPhenId(), vp.getValue()));
        return result;
    }

    public String getVarietyPhenotype(Long varietyId, String phenId) {
        List<VarietyPhenotype> data =
                varietyPhenotypeRepository.findByVarietyIdAndPhenId(varietyId, phenId);
        return data.isEmpty() ? null : data.get(0).getValue();
    }

    private PhenotypeDTO convertToDTO(Phenotype phenotype) {
        PhenotypeDTO dto = new PhenotypeDTO();
        dto.setPhenId(phenotype.getPhenId());
        dto.setName(phenotype.getName());
        dto.setDescription(phenotype.getDescription());
        return dto;
    }
}
