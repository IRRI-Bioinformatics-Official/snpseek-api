package org.irri.snpseek.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.irri.snpseek.DTO.VAllsampleBasicpropDTO;
import org.irri.snpseek.entity.VAllsampleBasicprop;
import org.irri.snpseek.repository.VAllsampleBasicpropRepository;
import org.springframework.stereotype.Service;

@Service
public class VAllsampleBasicpropService {

    private final VAllsampleBasicpropRepository repo;

    public VAllsampleBasicpropService(VAllsampleBasicpropRepository repo) {
        this.repo = repo;
    }

    public List<VAllsampleBasicpropDTO> findByDatasets(List<String> datasets) {
        List<VAllsampleBasicprop> rows = repo.findByDatasetInOrderByHdf5Index(datasets);
        return rows.stream().map(this::toDto).collect(Collectors.toList());
    }

    public VAllsampleBasicpropDTO findByStockSampleId(BigDecimal id) {
        VAllsampleBasicprop e = repo.findByStockSampleId(id);
        return e == null ? null : toDto(e);
    }

    // New: find by datasets and a list of stockSampleIds
    public List<VAllsampleBasicpropDTO> findByDatasetsAndSampleIds(List<String> datasets, List<BigDecimal> stockSampleIds) {
        if (stockSampleIds == null || stockSampleIds.isEmpty()) {
            return findByDatasets(datasets);
        }
        List<VAllsampleBasicprop> rows = repo.findByStockSampleIdInAndDatasetInOrderByHdf5Index(stockSampleIds, datasets);
        return rows.stream().map(this::toDto).collect(Collectors.toList());
    }

    // New usecase: accept a Set of datasets only, named to match the DAO named query
    public List<VAllsampleBasicpropDTO> findVAllsampleBasicpropByDatasetIn(Set<String> datasets) {
        if (datasets == null || datasets.isEmpty()) {
            return Collections.emptyList();
        }
        // repo expects a List; convert Set to List while preserving iteration order
        List<String> dsList = datasets.stream().collect(Collectors.toList());
        List<VAllsampleBasicprop> rows = repo.findByDatasetInOrderByHdf5Index(dsList);
        return rows.stream().map(this::toDto).collect(Collectors.toList());
    }

    private VAllsampleBasicpropDTO toDto(VAllsampleBasicprop e) {
        return new VAllsampleBasicpropDTO(e.getStockSampleId(), e.getAssay(), e.getDataset(), e.getHdf5Index(), e.getStockId(), e.getName(), e.getOriCountry(), e.getSubpopulation(), e.getBoxCode(), e.getGsAccession());
    }
}