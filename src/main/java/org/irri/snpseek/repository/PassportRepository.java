package org.irri.snpseek.repository;

import org.irri.snpseek.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {
    List<Passport> findByVarietyId(Long varietyId);
    List<Passport> findByPassId(String passId);
}
