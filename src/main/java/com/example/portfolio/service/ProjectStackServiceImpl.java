package com.example.portfolio.service;

import com.example.portfolio.dto.ProjectStackDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.mapper.ProjectStackMapper;
import com.example.portfolio.model.Project;
import com.example.portfolio.model.ProjectStack;
import com.example.portfolio.model.Stack;
import com.example.portfolio.repository.ProjectRepository;
import com.example.portfolio.repository.ProjectStackRepository;
import com.example.portfolio.repository.StackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectStackServiceImpl implements ProjectStackService {

    @Autowired
    private ProjectStackRepository projectStackRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private StackRepository stackRepository;

    @Autowired
    private ProjectStackMapper projectStackMapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProjectStackDTO saveProjectStackData(ProjectStackDTO newProjectStackDTO) throws RecordNotFoundException {
        Optional<Project> projectOptional = projectRepository.findById(newProjectStackDTO.getProjectId());
        Optional<Stack> stackOptional = stackRepository.findById(newProjectStackDTO.getStackId());
        if (projectOptional.isEmpty() || stackOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Project project = projectOptional.get();
        Stack stack = stackOptional.get();
        ProjectStack projectStack = projectStackMapper.dtoToModel(newProjectStackDTO);
        projectStack.setProject(project);
        projectStack.setStack(stack);
        ProjectStackDTO projectStackDTO = projectStackMapper.modelToDto(projectStackRepository.save(projectStack));
        projectStackDTO.setProjectId(project.getId());
        projectStackDTO.setStackId(stack.getId());
        return projectStackDTO;
    }

    @Override
    public ProjectStackDTO updateProjectStackData(Long id, ProjectStackDTO newProjectStackDTO) throws RecordNotFoundException {
        Optional<ProjectStack> projectStackOptional = projectStackRepository.findById(id);
        if (projectStackOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        ProjectStack projectStack = projectStackOptional.get();
        if (newProjectStackDTO.getProjectId() != null) {
            Optional<Project> projectOptional = projectRepository.findById(newProjectStackDTO.getProjectId());
            if (projectOptional.isEmpty()) {
                throw new RecordNotFoundException("Record not found");
            }
            projectStack.setProject(projectOptional.get());
        }
        if (newProjectStackDTO.getStackId() != null) {
            Optional<Stack> stackOptional = stackRepository.findById(newProjectStackDTO.getStackId());
            if (stackOptional.isEmpty()) {
                throw new RecordNotFoundException("Record not found");
            }
            projectStack.setStack(stackOptional.get());
        }
        projectStackRepository.save(projectStack);
        ProjectStackDTO projectStackDTO = projectStackMapper.modelToDto(projectStack);
        projectStackDTO.setProjectId(projectStack.getProject().getId());
        projectStackDTO.setStackId(projectStack.getStack().getId());
        return projectStackDTO;
    }

    @Override
    public void deleteProjectStackData(Long id) throws RecordNotFoundException {
        Optional<ProjectStack> projectStackOptional = projectStackRepository.findById(id);
        if (projectStackOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        projectStackRepository.deleteById(id);
    }
}
