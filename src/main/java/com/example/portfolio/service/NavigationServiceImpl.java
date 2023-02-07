package com.example.portfolio.service;

import com.example.portfolio.dto.NavigationDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.mapper.NavigationMapper;
import com.example.portfolio.model.Navigation;
import com.example.portfolio.repository.NavigationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    private NavigationRepository navigationRepository;

    @Autowired
    private NavigationMapper navigationMapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<NavigationDTO> getAllNavigationData() {
        return navigationRepository.findByOrderByIdAsc().stream().map(navigationMapper::modelToDto).toList();
    }

    @Override
    public NavigationDTO updateNavigationData(Long id, Navigation newNavigation) throws RecordNotFoundException {
        Optional<Navigation> navigationOptional = navigationRepository.findById(id);
        if (navigationOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Navigation navigation = navigationOptional.get();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(newNavigation, navigation);
        navigationRepository.save(navigation);
        return navigationMapper.modelToDto(navigation);
    }

}
