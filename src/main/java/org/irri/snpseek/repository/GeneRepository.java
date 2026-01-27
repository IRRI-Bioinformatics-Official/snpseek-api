package org.irri.snpseek.repository;

import org.irri.snpseek.entity.Gene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GeneRepository extends JpaRepository<Gene, Long> {
    @Query("SELECT g FROM Gene g WHERE g.contig = :contig AND g.startPos >= :start AND g.endPos <= :end")
    List<Gene> findByRegion(@Param("contig") String contig,
                            @Param("start") Long start,
                            @Param("end") Long end);
}
