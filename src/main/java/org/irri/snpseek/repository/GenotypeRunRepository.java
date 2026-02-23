package org.irri.snpseek.repository;

import java.util.List;

import org.irri.snpseek.entity.VGenotypeRun;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenotypeRunRepository extends JpaRepository<VGenotypeRun, Integer> {
	List<VGenotypeRun> findByDataset(String dataset);

	List<VGenotypeRun> findByVariantType(String variantType);

	List<VGenotypeRun> findByDatasetContainingIgnoreCase(String dataset);

	// Use property name 'commonname' to match the entity getter getCommonname()
	List<VGenotypeRun> findByCommonname(String commonname);

	// Case-insensitive contains search for common name
	List<VGenotypeRun> findByCommonnameContainingIgnoreCase(String commonname);

	// Use cases requested:
	// 1) get genotype runs by organism (common_name) and dataset
	List<VGenotypeRun> findByCommonnameContainingIgnoreCaseAndDataset(String commonname, String dataset);
	Page<VGenotypeRun> findByCommonnameContainingIgnoreCaseAndDataset(String commonname, String dataset, Pageable pageable);

	// 2) get genotype runs by variantset and dataset
	List<VGenotypeRun> findByVariantset(String variantset);
	List<VGenotypeRun> findByVariantsetAndDataset(String variantset, String dataset);
	Page<VGenotypeRun> findByVariantsetAndDataset(String variantset, String dataset, Pageable pageable);

	// 3) get genotype runs by variantset
	List<VGenotypeRun> findByVariantsetContainingIgnoreCase(String variantset);
	Page<VGenotypeRun> findByVariantsetContainingIgnoreCase(String variantset, Pageable pageable);
}