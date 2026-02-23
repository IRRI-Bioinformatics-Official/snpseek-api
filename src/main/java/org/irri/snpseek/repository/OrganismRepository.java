package org.irri.snpseek.repository;

import org.irri.snpseek.entity.Organism;
import org.irri.snpseek.entity.Stock; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrganismRepository extends JpaRepository<Organism, Integer> { 
	
	
	
  
}