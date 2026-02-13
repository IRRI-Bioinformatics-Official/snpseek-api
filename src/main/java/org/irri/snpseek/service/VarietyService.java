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
		return varietyRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public VarietyDTO getVarietyById(Integer id) {
		Variety variety = varietyRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Variety not found with id: " + id));

		// Convert Entity to DTO (assuming you have a mapper or constructor)
		return convertToDTO(variety);
	}

	
	

	public List<String> getAllVarietyNames() {
		return varietyRepository.findAll().stream().map(Variety::getName).collect(Collectors.toList());
	}

	public List<VarietyDTO> getVarietiesByNameLike(String name) {
		return varietyRepository.findByNameContainingIgnoreCase(name).stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public List<VarietyDTO> getVarietiesByOrganismId(Integer organismId) {
		return varietyRepository.findByOrganismId(organismId).stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	public List<VarietyDTO> getVarietiesByOrganismId(Integer organismId, String name) {
		return varietyRepository.findByOrganismId(organismId).stream()
				.filter(variety -> variety.getName() != null && variety.getName().toLowerCase().contains(name.toLowerCase()))
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	private VarietyDTO convertToDTO(Variety variety) {
		VarietyDTO dto = new VarietyDTO();
		dto.setVarietyId(variety.getVarietyId());
		dto.setName(variety.getName());
	
		return dto;
	}
}
