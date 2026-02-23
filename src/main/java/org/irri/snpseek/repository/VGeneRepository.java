package org.irri.snpseek.repository;

import org.irri.snpseek.entity.VGene;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface VGeneRepository extends JpaRepository<VGene, Integer> {
    Optional<VGene> findByGeneId(Integer geneId);

    List<VGene> findByNameContainingIgnoreCase(String name);

    // Pageable overload used when limit/offset is requested
    List<VGene> findByNameContainingIgnoreCase(String name, Pageable pageable);

    List<VGene> findByOrganismId(Integer organismId);

    // Pageable overload for organism query
    List<VGene> findByOrganismId(Integer organismId, Pageable pageable);
}