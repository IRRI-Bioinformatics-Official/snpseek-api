package org.irri.snpseek.repository;

import org.irri.snpseek.entity.VarietyPhenotype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VarietyPhenotypeRepository extends JpaRepository<VarietyPhenotype, Long> {
    List<VarietyPhenotype> findByVarietyId(Long varietyId);
    List<VarietyPhenotype> findByPhenId(String phenId);
    List<VarietyPhenotype> findByVarietyIdAndPhenId(Long varietyId, String phenId);
}
