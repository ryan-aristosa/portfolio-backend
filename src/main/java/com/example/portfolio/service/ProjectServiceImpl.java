package com.example.portfolio.service;

import com.example.portfolio.dto.ProjectDTO;
import com.example.portfolio.dto.ProjectSaveDTO;
import com.example.portfolio.dto.StackDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.mapper.ProjectMapper;
import com.example.portfolio.mapper.StackMapper;
import com.example.portfolio.model.Project;
import com.example.portfolio.repository.ProjectRepository;
import com.example.portfolio.repository.ProjectStackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectStackRepository projectStackRepository;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private StackMapper stackMapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<ProjectDTO> getProjectData() {
        List<Project> projectList = projectRepository.findByOrderByIdDesc();
        return projectList.stream().map(project -> {
            ProjectDTO projectDTO = projectMapper.modelToDto(project);
            Long projectId = project.getId();
            List<StackDTO> stackDTOList = projectStackRepository.findByProjectId(projectId)
                    .stream()
                    .map(expStack -> {
                        StackDTO stackDTO = stackMapper.modelToDto(expStack.getStack());
                        stackDTO.setFontColorCode(expStack.getStack().getFontColor().getColorCode());
                        return stackDTO;
                    })
                    .toList();
            projectDTO.setStackList(stackDTOList);
            return projectDTO;
        }).toList();
    }

    @Override
    public ProjectSaveDTO saveProjectData(ProjectSaveDTO newProjectSaveDTO) {
        Project project = projectRepository.save(projectMapper.saveDtoToModel(newProjectSaveDTO));
        return projectMapper.modelToSaveDto(project);
    }

    @Override
    public ProjectSaveDTO updateProjectData(Long id, ProjectSaveDTO newProjectSaveDTO) throws RecordNotFoundException {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Project project = projectOptional.get();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(newProjectSaveDTO, project);
        projectRepository.save(project);
        return projectMapper.modelToSaveDto(project);
    }

    @Override
    public void deleteProjectData(Long id) throws RecordNotFoundException {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        projectRepository.deleteById(id);
    }

}
