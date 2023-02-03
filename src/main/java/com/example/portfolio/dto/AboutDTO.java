package com.example.portfolio.dto;

import lombok.Data;

import java.util.List;

@Data
public class AboutDTO {

    private Long id;
    private String name;
    private String username;
    private List<AboutContentDTO> contentList;

}
