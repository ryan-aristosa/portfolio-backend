package com.example.portfolio.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDTO {

    private Long id;
    private String title;
    private String description;
    private String contribution;
    private List<StackDTO> stackList;
    private String openSourceLink;

}
