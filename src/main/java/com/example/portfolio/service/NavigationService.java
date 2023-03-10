package com.example.portfolio.service;

import com.example.portfolio.dto.NavigationDTO;
import com.example.portfolio.exception.RecordNotFoundException;

import java.util.List;

public interface NavigationService {

    List<NavigationDTO> getAllNavigationData();

    NavigationDTO updateNavigationData(Long id, NavigationDTO newNavigationDTO) throws RecordNotFoundException;

}
