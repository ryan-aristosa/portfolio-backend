package com.example.portfolio.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExperienceDTO {

    private Long id;
    private String duration;
    private List<ExpDescriptionDTO> descriptionList;
    private List<StackDTO> stackList;

}
