package com.example.portfolio.controller;

import com.example.portfolio.dto.ExperienceDTO;
import com.example.portfolio.dto.ExperienceSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "http://localhost:3000")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;


    @GetMapping
    public ResponseEntity<List<ExperienceDTO>> getExperience() {
        List<ExperienceDTO> experienceDTOList = experienceService.getExperienceData();
        return new ResponseEntity<>(experienceDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExperienceSaveDTO> saveExperience(@RequestBody ExperienceSaveDTO newExperienceSaveDTO) {
        return new ResponseEntity<>(experienceService.saveExperienceData(newExperienceSaveDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ExperienceSaveDTO> updateExperience
            (@PathVariable Long id, @RequestBody ExperienceSaveDTO newExperienceSaveDTO)
            throws RecordNotFoundException {
        return new ResponseEntity<>
                (experienceService.updateExperienceData(id, newExperienceSaveDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExperience(@PathVariable Long id) throws RecordNotFoundException {
        experienceService.deleteExperienceData(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }

}
