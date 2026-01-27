package com.example.brapi.service;

import com.example.brapi.dto.StudyDTO;
import com.example.brapi.entity.Study;
import com.example.brapi.repository.StudyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudyService {
    private final StudyRepository studyRepository;
    
    public StudyService(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public Page<StudyDTO> getAllStudies(Pageable pageable) {
        return studyRepository.findAll(pageable)
                .map(this::convertToDTO);
    }

    public StudyDTO getStudyById(String studyDbId) {
        Study study = studyRepository.findByStudyDbId(studyDbId)
                .orElseThrow(() -> new RuntimeException("Study not found: " + studyDbId));
        return convertToDTO(study);
    }

    public StudyDTO createStudy(StudyDTO studyDTO) {
        Study study = convertToEntity(studyDTO);
        Study saved = studyRepository.save(study);
        return convertToDTO(saved);
    }

    private StudyDTO convertToDTO(Study study) {
        StudyDTO dto = new StudyDTO();
        BeanUtils.copyProperties(study, dto);
        return dto;
    }

    private Study convertToEntity(StudyDTO dto) {
        Study study = new Study();
        BeanUtils.copyProperties(dto, study);
        return study;
    }
}
