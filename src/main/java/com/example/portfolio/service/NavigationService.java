package com.example.portfolio.service;

import com.example.portfolio.dto.NavigationDTO;
import com.example.portfolio.model.Navigation;

import java.util.List;

public interface NavigationService {

    List<NavigationDTO> getAllNavigationData();

    NavigationDTO updateNavigationData(Long id, Navigation newNavigation);

}
