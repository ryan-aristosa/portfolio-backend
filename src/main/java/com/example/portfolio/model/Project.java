package com.example.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String contribution;

    @OneToMany(mappedBy = "project")
    private List<ProjectStack> projectStackList;

    private String openSourceLink;

}
