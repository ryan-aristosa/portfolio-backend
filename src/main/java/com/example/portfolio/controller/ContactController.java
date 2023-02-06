package com.example.portfolio.controller;

import com.example.portfolio.dto.ContactDTO;
import com.example.portfolio.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    @Autowired
    private ContactService contactService;


    @GetMapping
    public ResponseEntity<List<ContactDTO>> getContactData() {
        List<ContactDTO> contactDTOList = contactService.getContactData();
        return new ResponseEntity<>(contactDTOList, HttpStatus.OK);
    }

}
