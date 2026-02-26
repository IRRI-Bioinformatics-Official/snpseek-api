package org.irri.snpseek.repository;

import java.math.BigDecimal;
import java.util.List;

import org.irri.snpseek.entity.VAllsampleBasicprop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VAllsampleBasicpropRepository extends JpaRepository<VAllsampleBasicprop, BigDecimal> {

    List<VAllsampleBasicprop> findByDatasetInOrderByHdf5Index(List<String> datasets);

    List<VAllsampleBasicprop> findByHdf5IndexBetween(Integer start, Integer end);

    VAllsampleBasicprop findByStockSampleId(BigDecimal stockSampleId);

}
