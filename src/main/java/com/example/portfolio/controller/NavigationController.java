package com.example.portfolio.controller;

import com.example.portfolio.dto.NavigationResponseDTO;
import com.example.portfolio.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/navigation")
@CrossOrigin(origins = "http://localhost:3000")
public class NavigationController {

    @Autowired
    private NavigationService navigationService;


    @GetMapping
    public ResponseEntity<List<NavigationResponseDTO>> getNavigationText() {
        List<NavigationResponseDTO> navigationResponseDTOList = navigationService.getAllNavigationText();
        return new ResponseEntity<>(navigationResponseDTOList, HttpStatus.OK);
    }

}
