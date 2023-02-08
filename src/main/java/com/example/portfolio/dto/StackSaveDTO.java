package com.example.portfolio.dto;

import lombok.Data;

@Data
public class StackSaveDTO {

    private Long id;
    private String stackName;
    private String primaryColorHex;
    private Long fontColorId;

}
