package org.irri.snpseek.repository;

import java.math.BigDecimal;
import java.util.List;

import org.irri.snpseek.entity.VScaffoldsOrganism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceSequenceRepository extends JpaRepository<VScaffoldsOrganism, BigDecimal> {

    List<VScaffoldsOrganism> findByOrganismId(BigDecimal organismId);

    List<VScaffoldsOrganism> findByNameContainingIgnoreCase(String name);

    List<VScaffoldsOrganism> findByOrganismIdAndType(BigDecimal organismId, String type);

}