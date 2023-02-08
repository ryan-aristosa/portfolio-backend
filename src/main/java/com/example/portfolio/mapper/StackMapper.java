package com.example.portfolio.mapper;

import com.example.portfolio.dto.StackDTO;
import com.example.portfolio.dto.StackSaveDTO;
import com.example.portfolio.model.Stack;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StackMapper {

    StackDTO modelToDto(Stack stack);

    Stack saveDtoToModel(StackSaveDTO stackSaveDTO);

}
