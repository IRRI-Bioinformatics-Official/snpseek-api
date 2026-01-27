package com.example.brapi.config;

import com.example.brapi.entity.Study;
import com.example.brapi.repository.StudyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {
    private final StudyRepository studyRepository;
    
    public DataLoader(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    @Override
    public void run(String... args) {
        // Load sample data
        Study study1 = new Study();
        study1.setStudyDbId(UUID.randomUUID().toString());
        study1.setStudyName("Rice Yield Trial 2025");
        study1.setStudyType("Phenotyping");
        study1.setStudyDescription("Evaluation of rice varieties for yield performance");
        study1.setStartDate(LocalDate.of(2025, 1, 1));
        study1.setEndDate(LocalDate.of(2025, 12, 31));
        study1.setActive(true);
        study1.setLocationDbId("LOC001");
        study1.setTrialDbId("TRIAL001");
        
        Study study2 = new Study();
        study2.setStudyDbId(UUID.randomUUID().toString());
        study2.setStudyName("Corn Disease Resistance Study");
        study2.setStudyType("Disease Screening");
        study2.setStudyDescription("Screening corn lines for disease resistance");
        study2.setStartDate(LocalDate.of(2025, 2, 1));
        study2.setEndDate(LocalDate.of(2025, 11, 30));
        study2.setActive(true);
        study2.setLocationDbId("LOC002");
        study2.setTrialDbId("TRIAL002");
        
        studyRepository.save(study1);
        studyRepository.save(study2);
        
        System.out.println("Sample data loaded successfully!");
    }
}