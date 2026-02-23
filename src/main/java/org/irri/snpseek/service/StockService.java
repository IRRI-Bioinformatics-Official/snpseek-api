package org.irri.snpseek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.irri.snpseek.DTO.StockDTO;
import org.irri.snpseek.entity.Stock;
import org.irri.snpseek.repository.StockRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StockService {
	private final StockRepository stockRepository;

	public StockService(StockRepository varietyRepository) {
		this.stockRepository = varietyRepository;
	}

	public List<StockDTO> getAllStocks() {
		return getAllStocks(0);
	}

	public List<StockDTO> getAllStocks(int limit) {
		if (limit > 0) {
			Pageable pageable = PageRequest.of(0, limit);
			return stockRepository.findAll(pageable).stream().map(this::convertToDTO).collect(Collectors.toList());
		}
		return stockRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public StockDTO getVarietyById(Integer id) {
		Stock stock = stockRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Variety not found with id: " + id));

		// Convert Entity to DTO (assuming you have a mapper or constructor)
		return convertToDTO(stock);
	}

	public List<String> getAllStockNames() {
		return stockRepository.findAll().stream().map(Stock::getName).collect(Collectors.toList());
	}

	public List<StockDTO> getStocksByNameLike(String name) {
		return stockRepository.findByNameContainingIgnoreCase(name).stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public List<StockDTO> getStocksByOrganismId(Integer organismId) {
		return getStocksByOrganismId(organismId, 0);
	}

	public List<StockDTO> getStocksByOrganismId(Integer organismId, int limit) {
		if (limit > 0) {
			Pageable pageable = PageRequest.of(0, limit);
			return stockRepository.findAll(pageable).stream()
				.filter(stock -> stock.getOrganismId() != null && stock.getOrganismId().equals(organismId.longValue()))
				.map(this::convertToDTO)
				.collect(Collectors.toList());
		}
		return stockRepository.findByOrganismId(organismId).stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public List<StockDTO> getVarietiesByOrganismId(Integer organismId, String name) {
		return getVarietiesByOrganismId(organismId, name, 0);
	}

	public List<StockDTO> getVarietiesByOrganismId(Integer organismId, String name, int limit) {
		if (limit > 0) {
			Pageable pageable = PageRequest.of(0, limit);
			return stockRepository.findAll(pageable).stream()
				.filter(stock -> stock.getOrganismId() != null && stock.getOrganismId().equals(organismId.longValue()))
				.filter(stock -> stock.getName() != null && stock.getName().toLowerCase().contains(name.toLowerCase()))
				.map(this::convertToDTO)
				.collect(Collectors.toList());
		}
		return stockRepository.findByOrganismId(organismId).stream()
			.filter(stock -> stock.getName() != null && stock.getName().toLowerCase().contains(name.toLowerCase()))
			.map(this::convertToDTO)
			.collect(Collectors.toList());
	}

	private StockDTO convertToDTO(Stock stock) {
		StockDTO dto = new StockDTO();
		dto.setVarietyId(stock.getVarietyId());
		dto.setName(stock.getName());
			dto.setDbxrefId(stock.getDbxrefId() != null ? new java.math.BigDecimal(stock.getDbxrefId()) : null);
			dto.setOrganismId(stock.getOrganismId() != null ? new java.math.BigDecimal(stock.getOrganismId()) : null);
			dto.setUniquename(stock.getUniquename());
			dto.setDescription(stock.getDescription());
			dto.setTypeId(stock.getTypeId() != null ? new java.math.BigDecimal(stock.getTypeId()) : null);
			dto.setIsObsolete(stock.getIsObsolete());
			dto.setStockGeolocationId(stock.getStockGeolocationId() != null ? new java.math.BigDecimal(stock.getStockGeolocationId()) : null);
			dto.setTmpOldstockId(stock.getTmpOldstockId() != null ? new java.math.BigDecimal(stock.getTmpOldstockId()) : null);
	
		return dto;
	}
}