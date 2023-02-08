package com.example.portfolio.controller;

import com.example.portfolio.dto.FooterDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.service.FooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/{id}")
    public ResponseEntity<FooterDTO> updateFooter(@PathVariable Long id, @RequestBody FooterDTO newFooterDTO)
            throws RecordNotFoundException {
        return new ResponseEntity<>(footerService.updateFooterData(id, newFooterDTO), HttpStatus.ACCEPTED);
    }

}
