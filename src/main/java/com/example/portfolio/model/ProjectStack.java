package com.example.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProjectStack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Stack stack;

}
