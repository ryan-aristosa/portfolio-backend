package com.example.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String colorCode;

    @OneToOne(mappedBy = "color")
    private Stack stack;

}
