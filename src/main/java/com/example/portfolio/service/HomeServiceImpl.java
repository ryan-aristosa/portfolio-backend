package com.example.portfolio.service;

import com.example.portfolio.dto.HomeDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.mapper.HomeMapper;
import com.example.portfolio.model.Home;
import com.example.portfolio.repository.HomeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private HomeMapper homeMapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public HomeDTO getHomeData() {
        return homeMapper.modelToDto(homeRepository.findFirstByOrderByIdAsc());
    }

    @Override
    public HomeDTO updateHomeData(Long id, Home newHome) throws RecordNotFoundException {
        Optional<Home> homeOptional = homeRepository.findById(id);
        if (homeOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Home home = homeOptional.get();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(newHome, home);
        homeRepository.save(home);
        return homeMapper.modelToDto(home);
    }

}
