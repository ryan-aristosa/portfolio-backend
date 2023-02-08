package com.example.portfolio.service;

import com.example.portfolio.dto.ProjectDTO;
import com.example.portfolio.dto.ProjectSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> getProjectData();

    ProjectSaveDTO saveProjectData(ProjectSaveDTO newProjectSaveDTO);

    ProjectSaveDTO updateProjectData(Long id, ProjectSaveDTO newProjectSaveDTO) throws RecordNotFoundException;

    void deleteProjectData(Long id) throws RecordNotFoundException;

}
