package com.example.portfolio.controller;

import com.example.portfolio.dto.ExperienceDTO;
import com.example.portfolio.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "http://localhost:3000")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;


    @GetMapping
    public ResponseEntity<List<ExperienceDTO>> getExperienceData() {
        List<ExperienceDTO> experienceDTOList = experienceService.getExperienceData();
        return new ResponseEntity<>(experienceDTOList, HttpStatus.OK);
    }

}
