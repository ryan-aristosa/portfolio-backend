package com.example.portfolio.mapper;

import com.example.portfolio.dto.AboutContentSpecificDTO;
import com.example.portfolio.model.AboutContent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AboutContentMapper {

    AboutContentSpecificDTO modelToSpecificDto(AboutContent aboutContent);

}
