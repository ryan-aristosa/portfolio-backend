package com.example.portfolio.controller;

import com.example.portfolio.dto.ExpDescriptionSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.service.ExpDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exp-description")
@CrossOrigin(origins = "http://localhost:3000")
public class ExpDescriptionController {

    @Autowired
    private ExpDescriptionService expDescriptionService;


    @PostMapping
    public ResponseEntity<ExpDescriptionSaveDTO> saveExpDescription
            (@RequestBody ExpDescriptionSaveDTO newExpDescriptionSaveDTO) throws RecordNotFoundException {
        return new ResponseEntity<>
                (expDescriptionService.saveExpDescriptionData(newExpDescriptionSaveDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ExpDescriptionSaveDTO> updateExpDescription
            (@PathVariable Long id, @RequestBody ExpDescriptionSaveDTO newExpDescriptionSaveDTO)
            throws RecordNotFoundException {
        return new ResponseEntity<>
                (expDescriptionService.updateExpDescriptionData(id, newExpDescriptionSaveDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpDescription(@PathVariable Long id) throws RecordNotFoundException {
        expDescriptionService.deleteExpDescriptionData(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }
}
