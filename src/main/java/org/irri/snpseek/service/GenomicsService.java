package org.irri.snpseek.service;

import org.irri.snpseek.entity.Gene;
import org.irri.snpseek.repository.GeneRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenomicsService {
    private final GeneRepository geneRepository;

    public GenomicsService(GeneRepository geneRepository) {
        this.geneRepository = geneRepository;
    }

    public List<Gene> getGenesByRegion(String contig, Long start, Long end, String model) {
        return geneRepository.findByRegion(contig, start, end);
    }
}
