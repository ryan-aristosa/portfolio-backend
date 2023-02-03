package com.example.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Stack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stackName;
    private String primaryColorHex;

    @OneToOne
    private FontColor fontColor;

    @OneToMany(mappedBy = "stack")
    private List<ExpStack> expStackList;

    @OneToMany(mappedBy = "stack")
    private List<ProjectStack> projectStackList;

}
