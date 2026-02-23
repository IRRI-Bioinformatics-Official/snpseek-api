package org.irri.snpseek.repository;

import java.math.BigDecimal;
import java.util.List;

import org.irri.snpseek.entity.VAllstockBasicprop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VAllstockBasicpropRepository extends JpaRepository<VAllstockBasicprop, BigDecimal> {

    @Query("select v from VAllstockBasicprop v where upper(v.dataset) in :datasets")
    List<VAllstockBasicprop> findAllByDatasets(@Param("datasets") List<String> datasets);

    @Query("select v from VAllstockBasicprop v where upper(v.dataset) in :datasets")
    Page<VAllstockBasicprop> findAllByDatasets(@Param("datasets") List<String> datasets, Pageable pageable);
}
