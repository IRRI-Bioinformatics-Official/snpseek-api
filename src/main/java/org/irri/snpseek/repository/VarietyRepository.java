package org.irri.snpseek.repository;

import org.irri.snpseek.entity.Variety; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface VarietyRepository extends JpaRepository<Variety, Integer> { 
	
	
	List<Variety> findByNameContainingIgnoreCase(String name);
	
	List<Variety> findByOrganismId(Integer orgnism);

  
}