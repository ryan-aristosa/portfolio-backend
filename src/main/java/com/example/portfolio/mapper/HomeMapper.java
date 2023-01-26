package com.example.portfolio.mapper;

import com.example.portfolio.dto.HomeResponseDTO;
import com.example.portfolio.model.Home;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HomeMapper {

    HomeResponseDTO modelToResponseDto(Home home);

}
