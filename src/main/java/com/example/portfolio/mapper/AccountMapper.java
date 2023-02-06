package com.example.portfolio.mapper;

import com.example.portfolio.dto.AccountDTO;
import com.example.portfolio.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDTO modelToDto(Account account);

}
