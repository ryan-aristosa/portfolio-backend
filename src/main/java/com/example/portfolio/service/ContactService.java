package com.example.portfolio.service;

import com.example.portfolio.dto.ContactDTO;
import com.example.portfolio.dto.ContactSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;

import java.util.List;

public interface ContactService {

    List<ContactDTO> getContactData();

    ContactSaveDTO saveContactData(ContactSaveDTO newContactSaveDTO);

    ContactSaveDTO updateContactData(Long id, ContactSaveDTO newContactSaveDTO) throws RecordNotFoundException;

    void deleteContactData(Long id) throws RecordNotFoundException;

}
