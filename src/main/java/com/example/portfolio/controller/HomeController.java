package com.example.portfolio.controller;

import com.example.portfolio.dto.HomeResponseDTO;
import com.example.portfolio.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @Autowired
    private HomeService homeService;


    @GetMapping
    public ResponseEntity<List<HomeResponseDTO>> getHomeTexts() {
        List<HomeResponseDTO> homeResponseDTOList = homeService.getAllHomeTexts();
        return new ResponseEntity<>(homeResponseDTOList, HttpStatus.OK);
    }

}
