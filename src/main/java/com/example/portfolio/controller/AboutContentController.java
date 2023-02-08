package com.example.portfolio.controller;

import com.example.portfolio.dto.AboutContentDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.service.AboutContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/about-content")
@CrossOrigin(origins = "http://localhost:3000")
public class AboutContentController {

    @Autowired
    private AboutContentService aboutContentService;


    @PostMapping
    public ResponseEntity<AboutContentDTO> saveAboutContent(@RequestBody AboutContentDTO newAboutContentDTO) {
        return new ResponseEntity<>(aboutContentService.saveAboutContentData(newAboutContentDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AboutContentDTO> updateAboutContent
            (@PathVariable Long id, @RequestBody AboutContentDTO newAboutContentDTO) throws RecordNotFoundException {
        return new ResponseEntity<>
                (aboutContentService.updateAboutContentData(id, newAboutContentDTO), HttpStatus.ACCEPTED);
    }

}
