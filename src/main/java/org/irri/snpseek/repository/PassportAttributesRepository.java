package org.irri.snpseek.repository;

import java.math.BigDecimal;
import java.util.List;

import org.irri.snpseek.entity.VCvPassportByDataset;
import org.irri.snpseek.entity.VCvPassportByDatasetId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportAttributesRepository extends JpaRepository<VCvPassportByDataset, VCvPassportByDatasetId> {
    List<VCvPassportByDataset> findByDataset(String dataset);

    List<VCvPassportByDataset> findByNameContainingIgnoreCaseAndDataset(String name, String dataset);

    List<VCvPassportByDataset> findByDefinitionContainingIgnoreCaseAndDataset(String definition, String dataset);

    VCvPassportByDataset findByCvTermIdAndDataset(BigDecimal cvTermId, String dataset);
}
