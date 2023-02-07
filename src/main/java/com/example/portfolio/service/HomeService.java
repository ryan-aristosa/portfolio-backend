package com.example.portfolio.service;

import com.example.portfolio.dto.HomeDTO;
import com.example.portfolio.exception.RecordNotFoundException;

public interface HomeService {

    HomeDTO getHomeData();

    HomeDTO updateHomeData(Long id, HomeDTO newHomeDTO) throws RecordNotFoundException;

}
