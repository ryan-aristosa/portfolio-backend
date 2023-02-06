package com.example.portfolio.mapper;

import com.example.portfolio.dto.ContactDTO;
import com.example.portfolio.model.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    ContactDTO modelToDto(Contact contact);

}
