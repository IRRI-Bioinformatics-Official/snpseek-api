package org.irri.snpseek.repository;

import java.util.List;

import org.irri.snpseek.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Integer> {
    List<Feature> findByOrganismId(Integer organismId);

    @Query("select f from Feature f where f.organismId = :organismId and (upper(f.uniquename) like upper(:q) or upper(f.name) like upper(:q))")
    List<Feature> findByOrganismIdAndUniqueNameOrName(@Param("organismId") Integer organismId, @Param("q") String q);
}