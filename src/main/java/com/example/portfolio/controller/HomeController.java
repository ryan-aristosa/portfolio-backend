package com.example.portfolio.controller;

import com.example.portfolio.dto.HomeDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.model.Home;
import com.example.portfolio.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @Autowired
    private HomeService homeService;


    @GetMapping
    public ResponseEntity<HomeDTO> getHome() {
        HomeDTO homeDTO = homeService.getHomeData();
        return new ResponseEntity<>(homeDTO, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HomeDTO> updateHome(@PathVariable Long id, @RequestBody Home newHome)
            throws RecordNotFoundException {
        return new ResponseEntity<>(homeService.updateHomeData(id, newHome), HttpStatus.OK);
    }

}
