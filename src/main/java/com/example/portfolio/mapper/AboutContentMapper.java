package com.example.portfolio.mapper;

import com.example.portfolio.dto.AboutContentDTO;
import com.example.portfolio.model.AboutContent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AboutContentMapper {

    AboutContentDTO modelToDto(AboutContent aboutContent);

    AboutContent dtoToModel(AboutContentDTO aboutContentDTO);

}
