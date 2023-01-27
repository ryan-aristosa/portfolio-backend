package com.example.portfolio.dto;

import lombok.Data;

import java.util.List;

@Data
public class AboutDTO {

    private Long id;
    private String title;
    private String name;
    private String username;
    private List<AboutContentSpecificDTO> aboutContentList;

}
