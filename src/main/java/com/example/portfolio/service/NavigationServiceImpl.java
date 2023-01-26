package com.example.portfolio.service;

import com.example.portfolio.dto.NavigationResponseDTO;
import com.example.portfolio.mapper.NavigationMapper;
import com.example.portfolio.repository.NavigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    private NavigationRepository navigationRepository;

    @Autowired
    private NavigationMapper navigationMapper;


    @Override
    public List<NavigationResponseDTO> getAllNavigationData() {
        return navigationRepository.findAll().stream().map(navigationMapper::modelToResponseDto).toList();
    }

}
