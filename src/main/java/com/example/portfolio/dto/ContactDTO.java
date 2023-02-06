package com.example.portfolio.dto;

import lombok.Data;

import java.util.List;

@Data
public class ContactDTO {

    private Long id;
    private String platform;
    private String icon;
    private List<AccountDTO> accountList;

}
