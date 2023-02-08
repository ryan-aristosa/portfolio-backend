package com.example.portfolio.controller;

import com.example.portfolio.dto.AboutDTO;
import com.example.portfolio.dto.AboutUpdateDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/about")
@CrossOrigin(origins = "http://localhost:3000")
public class AboutController {

    @Autowired
    private AboutService aboutService;


    @GetMapping
    public ResponseEntity<AboutDTO> getAbout() {
        AboutDTO aboutDTO = aboutService.getAboutData();
        return new ResponseEntity<>(aboutDTO, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AboutUpdateDTO> updateAbout
            (@PathVariable Long id, @RequestBody AboutUpdateDTO newAboutUpdateDTO) throws RecordNotFoundException {
        return new ResponseEntity<>(aboutService.updateAboutData(id, newAboutUpdateDTO), HttpStatus.ACCEPTED);
    }

}
