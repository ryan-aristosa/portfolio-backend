package com.example.portfolio.service;

import com.example.portfolio.dto.FooterDTO;
import com.example.portfolio.mapper.FooterMapper;
import com.example.portfolio.repository.FooterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooterServiceImpl implements FooterService {

    @Autowired
    private FooterRepository footerRepository;

    @Autowired
    private FooterMapper footerMapper;


    @Override
    public FooterDTO getFooterData() {
        return footerMapper.modelToDto(footerRepository.findFirstByOrderByIdAsc());
    }

}
