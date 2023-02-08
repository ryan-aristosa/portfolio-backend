package com.example.portfolio.controller;

import com.example.portfolio.dto.StackDTO;
import com.example.portfolio.dto.StackSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stack")
@CrossOrigin(origins = "http://localhost:3000")
public class StackController {

    @Autowired
    private StackService stackService;


    @PostMapping
    public ResponseEntity<StackDTO> saveStack(@RequestBody StackSaveDTO newStackSaveDTO)
            throws RecordNotFoundException {
        return new ResponseEntity<>(stackService.saveStackData(newStackSaveDTO), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StackDTO> updateStack(@PathVariable Long id, @RequestBody StackSaveDTO newStackSaveDTO)
            throws RecordNotFoundException {
        return new ResponseEntity<>(stackService.updateStackData(id, newStackSaveDTO), HttpStatus.OK);
    }

}
