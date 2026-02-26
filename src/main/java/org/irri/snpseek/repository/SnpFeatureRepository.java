package org.irri.snpseek.repository;

import org.irri.snpseek.entity.SnpFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnpFeatureRepository extends JpaRepository<SnpFeature, Long>, SnpFeatureRepositoryCustom {

}