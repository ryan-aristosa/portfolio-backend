package com.example.portfolio.service;

import com.example.portfolio.dto.HomeResponseDTO;
import com.example.portfolio.mapper.HomeMapper;
import com.example.portfolio.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private HomeMapper homeMapper;


    @Override
    public List<HomeResponseDTO> getAllHomeTexts() {
        return homeRepository.findAll().stream().map(homeMapper::modelToResponseDto).toList();
    }

}
