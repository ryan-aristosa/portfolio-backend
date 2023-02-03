package com.example.portfolio.service;

import com.example.portfolio.dto.ExpDescriptionDTO;
import com.example.portfolio.dto.ExperienceDTO;
import com.example.portfolio.dto.StackDTO;
import com.example.portfolio.mapper.ExpDescriptionMapper;
import com.example.portfolio.mapper.ExperienceMapper;
import com.example.portfolio.mapper.StackMapper;
import com.example.portfolio.model.Experience;
import com.example.portfolio.repository.ExpDescriptionRepository;
import com.example.portfolio.repository.ExpStackRepository;
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
    private ExpStackRepository expStackRepository;

    @Autowired
    private ExperienceMapper experienceMapper;

    @Autowired
    private ExpDescriptionMapper expDescriptionMapper;

    @Autowired
    private StackMapper stackMapper;


    @Override
    public List<ExperienceDTO> getExperienceData() {
        List<Experience> experienceList = experienceRepository.findByOrderByIdDesc();
        return experienceList.stream().map(experience -> {
            ExperienceDTO experienceDTO = experienceMapper.modelToDto(experience);
            Long experienceId = experience.getId();
            List<ExpDescriptionDTO> expDescriptionDTOList =
                    expDescriptionRepository.findByExperienceId(experienceId)
                            .stream()
                            .map(expDescriptionMapper::modelToDto)
                            .toList();
            experienceDTO.setDescriptionList(expDescriptionDTOList);
            List<StackDTO> stackDTOList = expStackRepository.findByExperienceId(experienceId)
                    .stream()
                    .map(expStack -> {
                        StackDTO stackDTO = stackMapper.modelToDto(expStack.getStack());
                        stackDTO.setFontColorCode(expStack.getStack().getFontColor().getColorCode());
                        return stackDTO;
                    })
                    .toList();
            experienceDTO.setStackList(stackDTOList);
            return experienceDTO;
        }).toList();
    }

}
