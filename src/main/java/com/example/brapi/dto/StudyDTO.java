package com.example.brapi.dto;

import java.time.LocalDate;

public class StudyDTO {
    private String studyDbId;
    private String studyName;
    private String studyType;
    private String studyDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean active;
    private String locationDbId;
    private String trialDbId;

    public StudyDTO() {
    }

    public StudyDTO(String studyDbId, String studyName, String studyType, String studyDescription,
                    LocalDate startDate, LocalDate endDate, Boolean active, String locationDbId, String trialDbId) {
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
