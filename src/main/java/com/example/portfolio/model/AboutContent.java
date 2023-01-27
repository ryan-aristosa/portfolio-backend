package com.example.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AboutContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private About about;

}
