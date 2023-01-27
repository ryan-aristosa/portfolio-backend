package com.example.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String duration;

    @OneToMany(mappedBy = "experience")
    private List<ExpDescription> expDescriptionList;

    @OneToMany(mappedBy = "experience")
    private List<ExpStack> expStackList;

}
