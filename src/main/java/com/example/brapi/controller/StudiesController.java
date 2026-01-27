package com.example.brapi.controller;

import com.example.brapi.dto.StudyDTO;
import com.example.brapi.model.BrapiResponse;
import com.example.brapi.service.StudyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studies")
public class StudiesController {
    private final StudyService studyService;
    
    public StudiesController(StudyService studyService) {
        this.studyService = studyService;
    }

    @GetMapping
    public ResponseEntity<BrapiResponse<List<StudyDTO>>> getStudies(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        
        Page<StudyDTO> studyPage = studyService.getAllStudies(
                PageRequest.of(page, pageSize));

        BrapiResponse<List<StudyDTO>> response = new BrapiResponse<>();
        response.setResult(studyPage.getContent());

        BrapiResponse.Metadata metadata = new BrapiResponse.Metadata();
        BrapiResponse.Pagination pagination = new BrapiResponse.Pagination();
        pagination.setCurrentPage(page);
        pagination.setPageSize(pageSize);
        pagination.setTotalCount((int) studyPage.getTotalElements());
        pagination.setTotalPages(studyPage.getTotalPages());
        metadata.setPagination(pagination);
        response.setMetadata(metadata);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{studyDbId}")
    public ResponseEntity<BrapiResponse<StudyDTO>> getStudy(
            @PathVariable String studyDbId) {
        
        StudyDTO study = studyService.getStudyById(studyDbId);
        BrapiResponse<StudyDTO> response = new BrapiResponse<>(study);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<BrapiResponse<StudyDTO>> createStudy(
            @RequestBody StudyDTO studyDTO) {
        
        StudyDTO created = studyService.createStudy(studyDTO);
        BrapiResponse<StudyDTO> response = new BrapiResponse<>(created);
        return ResponseEntity.ok(response);
    }
}