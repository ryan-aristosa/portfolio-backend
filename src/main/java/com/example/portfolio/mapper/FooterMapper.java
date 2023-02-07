package com.example.portfolio.mapper;

import com.example.portfolio.dto.FooterDTO;
import com.example.portfolio.model.Footer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FooterMapper {

    FooterDTO modelToDto(Footer footer);

}
