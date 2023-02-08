package com.example.portfolio.service;

import com.example.portfolio.dto.ExpDescriptionSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.mapper.ExpDescriptionMapper;
import com.example.portfolio.model.ExpDescription;
import com.example.portfolio.model.Experience;
import com.example.portfolio.repository.ExpDescriptionRepository;
import com.example.portfolio.repository.ExperienceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpDescriptionServiceImpl implements ExpDescriptionService {

    @Autowired
    private ExpDescriptionRepository expDescriptionRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ExpDescriptionMapper expDescriptionMapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ExpDescriptionSaveDTO saveExpDescriptionData(ExpDescriptionSaveDTO newExpDescriptionSaveDTO)
            throws RecordNotFoundException {
        Optional<Experience> experienceOptional =
                experienceRepository.findById(newExpDescriptionSaveDTO.getExperienceId());
        if (experienceOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Experience experience = experienceOptional.get();
        ExpDescription expDescription = expDescriptionMapper.saveDtoToModel(newExpDescriptionSaveDTO);
        expDescription.setExperience(experience);
        ExpDescriptionSaveDTO expDescriptionSaveDTO =
                expDescriptionMapper.modelToSaveDto(expDescriptionRepository.save(expDescription));
        expDescriptionSaveDTO.setExperienceId(experience.getId());
        return expDescriptionSaveDTO;
    }

    @Override
    public ExpDescriptionSaveDTO updateExpDescriptionData(Long id, ExpDescriptionSaveDTO newExpDescriptionSaveDTO)
            throws RecordNotFoundException {
        Optional<ExpDescription> expDescriptionOptional = expDescriptionRepository.findById(id);
        if (expDescriptionOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        ExpDescription expDescription = expDescriptionOptional.get();
        if (newExpDescriptionSaveDTO.getExperienceId() != null) {
            Optional<Experience> experienceOptional =
                    experienceRepository.findById(newExpDescriptionSaveDTO.getExperienceId());
            if (experienceOptional.isEmpty()) {
                throw new RecordNotFoundException("Record not found");
            }
            expDescription.setExperience(experienceOptional.get());
        }
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(newExpDescriptionSaveDTO, expDescription);
        expDescriptionRepository.save(expDescription);
        ExpDescriptionSaveDTO expDescriptionSaveDTO = expDescriptionMapper.modelToSaveDto(expDescription);
        expDescriptionSaveDTO.setExperienceId(expDescription.getExperience().getId());
        return expDescriptionSaveDTO;
    }

    @Override
    public void deleteExpDescriptionData(Long id) throws RecordNotFoundException {
        Optional<ExpDescription> expDescriptionOptional = expDescriptionRepository.findById(id);
        if (expDescriptionOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        expDescriptionRepository.deleteById(id);
    }
}
