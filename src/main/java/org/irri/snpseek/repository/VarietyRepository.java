package org.irri.snpseek.repository;

import org.irri.snpseek.entity.Variety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface VarietyRepository extends JpaRepository<Variety, Long> {
    Optional<Variety> findById(Long id);
    List<Variety> findBySubpopulation(String subpopulation);
    List<Variety> findByCountry(String country);
    List<Variety> findByNameContainingIgnoreCase(String name);
}