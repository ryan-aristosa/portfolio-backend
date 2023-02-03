package com.example.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FontColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String colorCode;

    @OneToOne(mappedBy = "fontColor")
    private Stack stack;

}
