package com.example.portfolio.mapper;

import com.example.portfolio.dto.ExpDescriptionDTO;
import com.example.portfolio.dto.ExpDescriptionSaveDTO;
import com.example.portfolio.model.ExpDescription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpDescriptionMapper {

    ExpDescriptionDTO modelToDto(ExpDescription expDescription);

    ExpDescription saveDtoToModel(ExpDescriptionSaveDTO expDescriptionSaveDTO);

    ExpDescriptionSaveDTO modelToSaveDto(ExpDescription expDescription);

}
