package com.example.portfolio.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectSaveDTO {

    private Long id;
    private String title;
    private String description;
    private String contribution;
    private String openSourceLink;

}
