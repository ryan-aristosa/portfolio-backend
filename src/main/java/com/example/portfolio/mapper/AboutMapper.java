package com.example.portfolio.mapper;

import com.example.portfolio.dto.AboutDTO;
import com.example.portfolio.model.About;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AboutMapper {

    AboutDTO modelToDto(About about);

}
