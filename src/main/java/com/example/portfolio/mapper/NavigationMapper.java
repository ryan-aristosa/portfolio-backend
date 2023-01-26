package com.example.portfolio.mapper;

import com.example.portfolio.dto.NavigationDTO;
import com.example.portfolio.model.Navigation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NavigationMapper {

    NavigationDTO modelToDto(Navigation navigation);

}
