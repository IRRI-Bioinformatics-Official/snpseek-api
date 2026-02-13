package org.irri.snpseek.repository;

import java.util.List;

import org.irri.snpseek.entity.VGenotypeRun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenotypeRunRepository extends JpaRepository<VGenotypeRun, Integer> {
    List<VGenotypeRun> findByDataset(String dataset);
    List<VGenotypeRun> findByVariantType(String variantType);
    List<VGenotypeRun> findByDatasetContainingIgnoreCase(String dataset);
}
