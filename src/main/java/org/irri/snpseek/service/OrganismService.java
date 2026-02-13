package org.irri.snpseek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.irri.snpseek.DTO.OrganismDTO;
import org.irri.snpseek.entity.Organism;
import org.irri.snpseek.repository.OrganismRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganismService {
	private final OrganismRepository organismRepository;

	public OrganismService(OrganismRepository organismRepository) {
		this.organismRepository = organismRepository;
	}

	public List<OrganismDTO> getAllOrganism() {
		return organismRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public OrganismDTO getOrganismById(Integer id) {
		Organism organism = organismRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Variety not found with id: " + id));

		// Convert Entity to DTO (assuming you have a mapper or constructor)
		return convertToDTO(organism);
	}

	private OrganismDTO convertToDTO(Organism organism) {
		OrganismDTO dto = new OrganismDTO();
		dto.setId(organism.getOrganismId());
		dto.setName(organism.getName());

		return dto;
	}
}
