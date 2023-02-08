package com.example.portfolio.controller;

import com.example.portfolio.dto.AccountSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping
    public ResponseEntity<AccountSaveDTO> saveAccount(@RequestBody AccountSaveDTO newAccountSaveDTO)
            throws RecordNotFoundException {
        return new ResponseEntity<>(accountService.saveAccountData(newAccountSaveDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AccountSaveDTO> updateAccount
            (@PathVariable Long id, @RequestBody AccountSaveDTO newAccountSaveDTO) throws RecordNotFoundException {
        return new ResponseEntity<>(accountService.updateAccountData(id, newAccountSaveDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) throws RecordNotFoundException {
        accountService.deleteAccountData(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }

}
