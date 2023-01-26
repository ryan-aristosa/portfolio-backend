package com.example.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String name;
    private String username;

    @OneToMany(mappedBy = "about", cascade = CascadeType.ALL)
    private List<AboutContent> aboutContentList;

}
