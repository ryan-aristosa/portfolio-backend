package com.example.portfolio.controller;

import com.example.portfolio.dto.FooterDTO;
import com.example.portfolio.service.FooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/footer")
@CrossOrigin(origins = "http://localhost:3000")
public class FooterController {

    @Autowired
    private FooterService footerService;


    @GetMapping
    public ResponseEntity<FooterDTO> getFooterData() {
        FooterDTO footerDTO = footerService.getFooterData();
        return new ResponseEntity<>(footerDTO, HttpStatus.OK);
    }

}
