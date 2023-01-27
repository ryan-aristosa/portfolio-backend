package com.example.portfolio.mapper;

import com.example.portfolio.dto.ExperienceDTO;
import com.example.portfolio.dto.ExperienceSpecificDTO;
import com.example.portfolio.model.Experience;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    ExperienceSpecificDTO modelToSpecificDto(Experience experience);

    ExperienceDTO specificDtoToDto(ExperienceSpecificDTO experienceSpecificDTO);

}
