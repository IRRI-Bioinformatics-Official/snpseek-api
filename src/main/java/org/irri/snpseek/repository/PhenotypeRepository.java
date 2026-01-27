package org.irri.snpseek.repository;

import org.irri.snpseek.entity.Phenotype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PhenotypeRepository extends JpaRepository<Phenotype, Long> {
    Optional<Phenotype> findByPhenId(String phenId);
}
