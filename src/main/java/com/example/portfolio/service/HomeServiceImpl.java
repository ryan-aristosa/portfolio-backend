package com.example.portfolio.service;

import com.example.portfolio.dto.HomeResponseDTO;
import com.example.portfolio.mapper.HomeMapper;
import com.example.portfolio.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private HomeMapper homeMapper;


    @Override
    public HomeResponseDTO getHomeData() {
        return homeMapper.modelToResponseDto(homeRepository.findFirstByOrderByIdAsc());
//        return homeRepository.findAll().stream().map(homeMapper::modelToResponseDto).toList();
    }

}
