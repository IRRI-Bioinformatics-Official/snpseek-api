package com.example.brapi.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "studies")
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String studyDbId;
    
    private String studyName;
    private String studyType;
    
    @Column(length = 1000)
    private String studyDescription;
    
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean active;
    private String locationDbId;
    private String trialDbId;

    public Study() {
    }

    public Study(Long id, String studyDbId, String studyName, String studyType, String studyDescription,
                 LocalDate startDate, LocalDate endDate, Boolean active, String locationDbId, String trialDbId) {
        this.id = id;
        this.studyDbId = studyDbId;
        this.studyName = studyName;
        this.studyType = studyType;
        this.studyDescription = studyDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.locationDbId = locationDbId;
        this.trialDbId = trialDbId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudyDbId() {
        return studyDbId;
    }

    public void setStudyDbId(String studyDbId) {
        this.studyDbId = studyDbId;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public String getStudyDescription() {
        return studyDescription;
    }

    public void setStudyDescription(String studyDescription) {
        this.studyDescription = studyDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getLocationDbId() {
        return locationDbId;
    }

    public void setLocationDbId(String locationDbId) {
        this.locationDbId = locationDbId;
    }

    public String getTrialDbId() {
        return trialDbId;
    }

    public void setTrialDbId(String trialDbId) {
        this.trialDbId = trialDbId;
    }
}