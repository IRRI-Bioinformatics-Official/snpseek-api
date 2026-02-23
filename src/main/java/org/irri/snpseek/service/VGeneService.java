package org.irri.snpseek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.irri.snpseek.DTO.VGeneDTO;
import org.irri.snpseek.entity.VGene;
import org.irri.snpseek.repository.VGeneRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VGeneService {
	private final VGeneRepository vGeneRepository;

	public VGeneService(VGeneRepository vGeneRepository) {
		this.vGeneRepository = vGeneRepository;
	}

	public List<VGeneDTO> getAllVGenes() {
		return getAllVGenes(null, null);
	}

	// New: support optional limit/offset
	public List<VGeneDTO> getAllVGenes(Integer limit, Integer offset) {
		if (limit != null && limit > 0) {
			int page = 0;
			if (offset != null && offset > 0) {
				page = offset / limit; // integer division, matches typical SQL OFFSET behaviour approximately
			}
			return vGeneRepository.findAll(PageRequest.of(page, limit)).stream().map(this::toDto)
					.collect(Collectors.toList());
		}
		return vGeneRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
	}

	public VGeneDTO getVGeneById(Integer id) {
		VGene vg = vGeneRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("VGene not found with id: " + id));
		return toDto(vg);
	}

	// Existing search
	public List<VGeneDTO> searchByName(String name) {
		return searchByName(name, null, null);
	}

	// New: search with optional limit/offset
	public List<VGeneDTO> searchByName(String name, Integer limit, Integer offset) {
		if (limit != null && limit > 0) {
			int page = 0;
			if (offset != null && offset > 0) {
				page = offset / limit;
			}
			return vGeneRepository.findByNameContainingIgnoreCase(name, PageRequest.of(page, limit)).stream()
					.map(this::toDto).collect(Collectors.toList());
		}
		return vGeneRepository.findByNameContainingIgnoreCase(name).stream().map(this::toDto)
				.collect(Collectors.toList());
	}

	public List<VGeneDTO> getByOrganism(Integer organismId) {
		return getByOrganism(organismId, null, null);
	}

	public List<VGeneDTO> getByOrganism(Integer organismId, Integer limit, Integer offset) {
		if (limit != null && limit > 0) {
			int page = 0;
			if (offset != null && offset > 0) {
				page = offset / limit;
			}
			return vGeneRepository.findByOrganismId(organismId, PageRequest.of(page, limit)).stream().map(this::toDto)
					.collect(Collectors.toList());
		}
		return vGeneRepository.findByOrganismId(organismId).stream().map(this::toDto).collect(Collectors.toList());
	}

	public VGeneDTO save(VGeneDTO dto) {
		VGene entity = toEntity(dto);
		VGene saved = vGeneRepository.save(entity);
		return toDto(saved);
	}

	public void delete(Integer id) {
		if (!vGeneRepository.existsById(id))
			throw new RuntimeException("VGene not found with id: " + id);
		vGeneRepository.deleteById(id);
	}

	private VGeneDTO toDto(VGene e) {
		VGeneDTO d = new VGeneDTO();
		d.setGeneId(e.getGeneId());
		d.setName(e.getName());
		d.setChr(e.getChr() != null ? e.getChr().toString() : null);
		d.setFmin(e.getFmin());
		d.setFmax(e.getFmax());
		d.setStrand(e.getStrand());
		d.setPhase(e.getPhase());
		d.setOrganismId(e.getOrganismId());
		return d;
	}

	private VGene toEntity(VGeneDTO d) {
		VGene e = new VGene();
		if (d.getGeneId() != null)
			e.setGeneId(d.getGeneId());
		e.setName(d.getName());
		if (d.getChr() != null)
			e.setChr(d.getChr());
		e.setFmin(d.getFmin());
		e.setFmax(d.getFmax());
		e.setStrand(d.getStrand());
		e.setPhase(d.getPhase());
		e.setOrganismId(d.getOrganismId());
		return e;
	}
}
