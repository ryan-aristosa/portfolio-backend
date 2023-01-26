package com.example.portfolio.mapper;

import com.example.portfolio.dto.AboutDTO;
import com.example.portfolio.dto.AboutSpecificDTO;
import com.example.portfolio.model.About;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AboutMapper {

    AboutSpecificDTO modelToSpecificDTO(About about);

    AboutDTO specificDtoToDto(AboutSpecificDTO aboutSpecificDTO);

}
