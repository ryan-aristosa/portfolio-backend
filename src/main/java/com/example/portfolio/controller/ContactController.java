package com.example.portfolio.controller;

import com.example.portfolio.dto.ContactDTO;
import com.example.portfolio.dto.ContactSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    @Autowired
    private ContactService contactService;


    @GetMapping
    public ResponseEntity<List<ContactDTO>> getContact() {
        List<ContactDTO> contactDTOList = contactService.getContactData();
        return new ResponseEntity<>(contactDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContactSaveDTO> saveContact(@RequestBody ContactSaveDTO newContactSaveDTO) {
        return new ResponseEntity<>(contactService.saveContactData(newContactSaveDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ContactSaveDTO> updateContact
            (@PathVariable Long id, @RequestBody ContactSaveDTO newContactSaveDTO) throws RecordNotFoundException {
        return new ResponseEntity<>(contactService.updateContactData(id, newContactSaveDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) throws RecordNotFoundException {
        contactService.deleteContactData(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }

}
