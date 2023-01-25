package com.example.portfolio.mapper;

import com.example.portfolio.dto.NavigationResponseDTO;
import com.example.portfolio.model.Navigation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NavigationMapper {

    NavigationResponseDTO modelToResponseDto(Navigation navigation);

}
