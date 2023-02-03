package com.example.portfolio.service;

import com.example.portfolio.dto.ProjectDTO;
import com.example.portfolio.dto.StackDTO;
import com.example.portfolio.mapper.ProjectMapper;
import com.example.portfolio.mapper.StackMapper;
import com.example.portfolio.model.Project;
import com.example.portfolio.repository.ProjectRepository;
import com.example.portfolio.repository.ProjectStackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
