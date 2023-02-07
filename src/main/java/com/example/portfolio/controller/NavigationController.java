package com.example.portfolio.controller;

import com.example.portfolio.dto.NavigationDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.model.Navigation;
import com.example.portfolio.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/navigation")
@CrossOrigin(origins = "http://localhost:3000")
public class NavigationController {

    @Autowired
    private NavigationService navigationService;


    @GetMapping
    public ResponseEntity<List<NavigationDTO>> getAllNavigation() {
        return new ResponseEntity<>(navigationService.getAllNavigationData(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<NavigationDTO> updateNavigation
            (@PathVariable Long id, @RequestBody NavigationDTO newNavigationDTO) throws RecordNotFoundException {
        return new ResponseEntity<>(navigationService.updateNavigationData(id, newNavigationDTO), HttpStatus.OK);
    }

}
