package com.example.portfolio.mapper;

import com.example.portfolio.dto.HomeDTO;
import com.example.portfolio.model.Home;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HomeMapper {

    HomeDTO modelToDto(Home home);

}
