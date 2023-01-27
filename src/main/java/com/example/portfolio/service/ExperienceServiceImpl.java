package com.example.portfolio.service;

import com.example.portfolio.dto.ExpDescriptionSpecificDTO;
import com.example.portfolio.dto.ExperienceDTO;
import com.example.portfolio.dto.ExperienceSpecificDTO;
import com.example.portfolio.mapper.ExpDescriptionMapper;
import com.example.portfolio.mapper.ExperienceMapper;
import com.example.portfolio.model.Experience;
import com.example.portfolio.repository.ExpDescriptionRepository;
import com.example.portfolio.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ExpDescriptionRepository expDescriptionRepository;

    @Autowired
    private ExperienceMapper experienceMapper;

    @Autowired
    private ExpDescriptionMapper expDescriptionMapper;


    @Override
    public List<ExperienceDTO> getExperienceData() {
        List<Experience> experience = experienceRepository.findByOrderByIdDesc();
        return experience.stream().map(exp -> {
            ExperienceSpecificDTO experienceSpecificDTO = experienceMapper.modelToSpecificDto(exp);
            ExperienceDTO experienceDTO = experienceMapper.specificDtoToDto(experienceSpecificDTO);
            Long experienceId = exp.getId();
            List<ExpDescriptionSpecificDTO> expDescriptionSpecificDTOList =
                    expDescriptionRepository.findByExperienceId(experienceId)
                            .stream()
                            .map(expDescriptionMapper::modelToSpecificDto)
                            .toList();
            experienceDTO.setExpDescriptionList(expDescriptionSpecificDTOList);
            return experienceDTO;
        }).toList();
    }

}
