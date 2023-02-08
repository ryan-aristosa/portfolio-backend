package com.example.portfolio.mapper;

import com.example.portfolio.dto.ProjectStackDTO;
import com.example.portfolio.model.ProjectStack;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectStackMapper {

    ProjectStack dtoToModel(ProjectStackDTO projectStackDTO);

    ProjectStackDTO modelToDto(ProjectStack projectStack);

}
