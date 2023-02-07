package com.example.portfolio.service;

import com.example.portfolio.dto.HomeDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.model.Home;

public interface HomeService {

    HomeDTO getHomeData();

    HomeDTO updateHomeData(Long id, Home newHome) throws RecordNotFoundException;

}
