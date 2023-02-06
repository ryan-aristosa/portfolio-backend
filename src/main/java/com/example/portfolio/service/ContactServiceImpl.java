package com.example.portfolio.service;

import com.example.portfolio.dto.AccountDTO;
import com.example.portfolio.dto.ContactDTO;
import com.example.portfolio.mapper.AccountMapper;
import com.example.portfolio.mapper.ContactMapper;
import com.example.portfolio.model.Contact;
import com.example.portfolio.repository.AccountRepository;
import com.example.portfolio.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public List<ContactDTO> getContactData() {
        List<Contact> contactList = contactRepository.findAll();
        return contactList.stream().map(contact -> {
            ContactDTO contactDTO = contactMapper.modelToDto(contact);
            Long contactId = contact.getId();
            List<AccountDTO> accountDTOList = accountRepository.findByContactId(contactId)
                    .stream()
                    .map(account -> accountMapper.modelToDto(account))
                    .toList();
            contactDTO.setAccountList(accountDTOList);
            return contactDTO;
        }).toList();
    }

}
