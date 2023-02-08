package com.example.portfolio.service;

import com.example.portfolio.dto.ProjectStackDTO;
import com.example.portfolio.exception.RecordNotFoundException;

public interface ProjectStackService {

    ProjectStackDTO saveProjectStackData(ProjectStackDTO newProjectStackDTO) throws RecordNotFoundException;

    ProjectStackDTO updateProjectStackData(Long id, ProjectStackDTO newProjectStackDTO) throws RecordNotFoundException;

    void deleteProjectStackData(Long id) throws RecordNotFoundException;

}
