package com.example.portfolio.service;

import com.example.portfolio.dto.FooterDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.mapper.FooterMapper;
import com.example.portfolio.model.Footer;
import com.example.portfolio.repository.FooterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FooterServiceImpl implements FooterService {

    @Autowired
    private FooterRepository footerRepository;

    @Autowired
    private FooterMapper footerMapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public FooterDTO getFooterData() {
        return footerMapper.modelToDto(footerRepository.findFirstByOrderByIdAsc());
    }

    @Override
    public FooterDTO updateFooterData(Long id, FooterDTO newFooterDTO) throws RecordNotFoundException {
        Optional<Footer> footerOptional = footerRepository.findById(id);
        if (footerOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Footer footer = footerOptional.get();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(newFooterDTO, footer);
        footerRepository.save(footer);
        return footerMapper.modelToDto(footer);
    }

}
