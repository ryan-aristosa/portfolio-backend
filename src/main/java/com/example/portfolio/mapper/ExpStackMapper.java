package com.example.portfolio.mapper;

import com.example.portfolio.dto.ExpStackDTO;
import com.example.portfolio.model.ExpStack;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpStackMapper {

    ExpStack dtoToModel(ExpStackDTO expStackDTO);

    ExpStackDTO modelToDto(ExpStack expStack);

}
