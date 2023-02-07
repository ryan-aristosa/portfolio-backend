package com.example.portfolio.controller;

import com.example.portfolio.dto.AboutContentDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.model.AboutContent;
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
    public ResponseEntity<AboutContentDTO> getAboutContent(@RequestBody AboutContent aboutContent) {
        return new ResponseEntity<>(aboutContentService.saveAboutContentData(aboutContent), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AboutContentDTO> updateAboutContent
            (@PathVariable Long id, @RequestBody AboutContent aboutContent) throws RecordNotFoundException {
        return new ResponseEntity<>(aboutContentService.updateAboutContentData(id, aboutContent), HttpStatus.OK);
    }

}
