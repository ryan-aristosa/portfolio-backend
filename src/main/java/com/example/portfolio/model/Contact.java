package com.example.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String platform;
    private String icon;

    @OneToMany(mappedBy = "contact")
    private List<Account> account;

}
