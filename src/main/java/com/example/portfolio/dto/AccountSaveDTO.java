package com.example.portfolio.dto;

import lombok.Data;

@Data
public class AccountSaveDTO {

    private Long id;
    private String accountName;
    private String link;
    private Long contactId;

}
