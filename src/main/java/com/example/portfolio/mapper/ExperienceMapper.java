package com.example.portfolio.mapper;

import com.example.portfolio.dto.ExperienceDTO;
import com.example.portfolio.dto.ExperienceSaveDTO;
import com.example.portfolio.model.Experience;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    ExperienceDTO modelToDto(Experience experience);

    Experience saveDtoToModel(ExperienceSaveDTO experienceSaveDTO);

    ExperienceSaveDTO modelToSaveDto(Experience experience);

}
