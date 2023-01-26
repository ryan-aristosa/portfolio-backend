package com.example.portfolio.controller;

import com.example.portfolio.dto.AboutDTO;
import com.example.portfolio.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about")
@CrossOrigin(origins = "http://localhost:3000")
public class AboutController {

    @Autowired
    private AboutService aboutService;


    @GetMapping
    public ResponseEntity<AboutDTO> getAboutData() {
        AboutDTO aboutDTO = aboutService.getAboutData();
        return new ResponseEntity<>(aboutDTO, HttpStatus.OK);
    }

}
