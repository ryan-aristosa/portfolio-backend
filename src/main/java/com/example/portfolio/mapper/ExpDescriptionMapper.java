package com.example.portfolio.mapper;

import com.example.portfolio.dto.ExpDescriptionSpecificDTO;
import com.example.portfolio.model.ExpDescription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpDescriptionMapper {

    ExpDescriptionSpecificDTO modelToSpecificDto(ExpDescription expDescription);

}
