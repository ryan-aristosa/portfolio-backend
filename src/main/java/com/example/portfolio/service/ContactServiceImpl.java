package com.example.portfolio.service;

import com.example.portfolio.dto.AccountDTO;
import com.example.portfolio.dto.ContactDTO;
import com.example.portfolio.dto.ContactSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.mapper.AccountMapper;
import com.example.portfolio.mapper.ContactMapper;
import com.example.portfolio.model.Contact;
import com.example.portfolio.repository.AccountRepository;
import com.example.portfolio.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    private ModelMapper modelMapper;


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

    @Override
    public ContactSaveDTO saveContactData(ContactSaveDTO newContactSaveDTO) {
        Contact contact = contactRepository.save(contactMapper.saveDtoToModel(newContactSaveDTO));
        return contactMapper.modelToSaveDto(contact);
    }

    @Override
    public ContactSaveDTO updateContactData(Long id, ContactSaveDTO newContactSaveDTO) throws RecordNotFoundException {
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if (contactOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Contact contact = contactOptional.get();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(newContactSaveDTO, contact);
        contactRepository.save(contact);
        return contactMapper.modelToSaveDto(contact);
    }

    @Override
    public void deleteContactData(Long id) throws RecordNotFoundException {
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if (contactOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        contactRepository.deleteById(id);
    }

}
