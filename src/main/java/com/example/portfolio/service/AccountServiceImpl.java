package com.example.portfolio.service;

import com.example.portfolio.dto.AccountSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.mapper.AccountMapper;
import com.example.portfolio.mapper.ContactMapper;
import com.example.portfolio.model.Account;
import com.example.portfolio.model.Contact;
import com.example.portfolio.repository.AccountRepository;
import com.example.portfolio.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AccountSaveDTO saveAccountData(AccountSaveDTO newAccountSaveDTO) throws RecordNotFoundException {
        Optional<Contact> contactOptional = contactRepository.findById(newAccountSaveDTO.getContactId());
        if (contactOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Contact contact = contactOptional.get();
        Account account = accountMapper.saveDtoToModel(newAccountSaveDTO);
        account.setContact(contact);
        AccountSaveDTO accountSaveDTO = accountMapper.modelToSaveDto(accountRepository.save(account));
        accountSaveDTO.setContactId(contact.getId());
        return accountSaveDTO;
    }

    @Override
    public AccountSaveDTO updateAccountData(Long id, AccountSaveDTO newAccountSaveDTO) throws RecordNotFoundException {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Account account = accountOptional.get();
        if (newAccountSaveDTO.getContactId() != null) {
            Optional<Contact> contactOptional = contactRepository.findById(newAccountSaveDTO.getContactId());
            if (contactOptional.isEmpty()) {
                throw new RecordNotFoundException("Record not found");
            }
            account.setContact(contactOptional.get());
        }
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(newAccountSaveDTO, account);
        accountRepository.save(account);
        AccountSaveDTO accountSaveDTO = accountMapper.modelToSaveDto(account);
        accountSaveDTO.setContactId(account.getContact().getId());
        return accountSaveDTO;
    }

    @Override
    public void deleteAccountData(Long id) throws RecordNotFoundException {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        accountRepository.deleteById(id);
    }

}
