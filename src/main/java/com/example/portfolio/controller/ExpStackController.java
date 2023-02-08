package com.example.portfolio.controller;

import com.example.portfolio.dto.ExpStackDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.service.ExpStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exp-stack")
@CrossOrigin(origins = "http://localhost:3000")
public class ExpStackController {

    @Autowired
    private ExpStackService expStackService;


    @PostMapping
    public ResponseEntity<ExpStackDTO> saveExpStack(@RequestBody ExpStackDTO newExpStackDTO)
            throws RecordNotFoundException {
        return new ResponseEntity<>(expStackService.saveExpStackData(newExpStackDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ExpStackDTO> updateExpStack(@PathVariable Long id, @RequestBody ExpStackDTO newExpStackDTO)
            throws RecordNotFoundException {
        return new ResponseEntity<>(expStackService.updateExpStackData(id, newExpStackDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpDescription(@PathVariable Long id) throws RecordNotFoundException {
        expStackService.deleteExpStackData(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }

}
