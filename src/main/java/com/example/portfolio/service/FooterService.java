package com.example.portfolio.service;

import com.example.portfolio.dto.FooterDTO;
import com.example.portfolio.exception.RecordNotFoundException;

public interface FooterService {

    FooterDTO getFooterData();

    FooterDTO updateFooterData(Long id, FooterDTO newFooterDTO) throws RecordNotFoundException;

}
