package org.irri.snpseek.service;

import java.math.BigDecimal;
import java.util.List;
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

    private VAllsampleBasicpropDTO toDto(VAllsampleBasicprop e) {
        return new VAllsampleBasicpropDTO(e.getStockSampleId(), e.getAssay(), e.getDataset(), e.getHdf5Index(), e.getStockId(), e.getName(), e.getOriCountry(), e.getSubpopulation(), e.getBoxCode(), e.getGsAccession());
    }
}
