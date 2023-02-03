package com.example.portfolio.mapper;

import com.example.portfolio.dto.ProjectDTO;
import com.example.portfolio.model.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectDTO modelToDto(Project project);

}
