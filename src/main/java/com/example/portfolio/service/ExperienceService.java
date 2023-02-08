package com.example.portfolio.service;

import com.example.portfolio.dto.ExperienceDTO;
import com.example.portfolio.dto.ExperienceSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;

import java.util.List;

public interface ExperienceService {

    List<ExperienceDTO> getExperienceData();

    ExperienceSaveDTO saveExperienceData(ExperienceSaveDTO newExperienceSaveDTO) throws RecordNotFoundException;

    ExperienceSaveDTO updateExperienceData(Long id, ExperienceSaveDTO newExperienceSaveDTO)
            throws RecordNotFoundException;

    void deleteExperienceData(Long id) throws RecordNotFoundException;

}
