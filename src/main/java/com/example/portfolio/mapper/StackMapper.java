package com.example.portfolio.mapper;

import com.example.portfolio.dto.StackSpecificDTO;
import com.example.portfolio.model.Stack;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StackMapper {

    StackSpecificDTO modelToSpecificDto(Stack stack);

}
