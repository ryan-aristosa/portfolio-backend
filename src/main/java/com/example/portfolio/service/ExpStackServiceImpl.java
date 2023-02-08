package com.example.portfolio.service;

import com.example.portfolio.dto.ExpStackDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.mapper.ExpStackMapper;
import com.example.portfolio.model.ExpStack;
import com.example.portfolio.model.Experience;
import com.example.portfolio.model.Stack;
import com.example.portfolio.repository.ExpStackRepository;
import com.example.portfolio.repository.ExperienceRepository;
import com.example.portfolio.repository.StackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpStackServiceImpl implements ExpStackService {

    @Autowired
    private ExpStackRepository expStackRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private StackRepository stackRepository;

    @Autowired
    private ExpStackMapper expStackMapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ExpStackDTO saveExpStackData(ExpStackDTO newExpStackDTO) throws RecordNotFoundException {
        Optional<Experience> experienceOptional = experienceRepository.findById(newExpStackDTO.getExperienceId());
        Optional<Stack> stackOptional = stackRepository.findById(newExpStackDTO.getStackId());
        if (experienceOptional.isEmpty() || stackOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Experience experience = experienceOptional.get();
        Stack stack = stackOptional.get();
        ExpStack expStack = expStackMapper.dtoToModel(newExpStackDTO);
        expStack.setExperience(experience);
        expStack.setStack(stack);
        ExpStackDTO expStackDTO = expStackMapper.modelToDto(expStackRepository.save(expStack));
        expStackDTO.setExperienceId(experience.getId());
        expStackDTO.setStackId(stack.getId());
        return expStackDTO;
    }

    @Override
    public ExpStackDTO updateExpStackData(Long id, ExpStackDTO newExpStackDTO) throws RecordNotFoundException {
        Optional<ExpStack> expStackOptional = expStackRepository.findById(id);
        if (expStackOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        ExpStack expStack = expStackOptional.get();
        if (newExpStackDTO.getExperienceId() != null) {
            Optional<Experience> experienceOptional = experienceRepository.findById(newExpStackDTO.getExperienceId());
            if (experienceOptional.isEmpty()) {
                throw new RecordNotFoundException("Record not found");
            }
            expStack.setExperience(experienceOptional.get());
        }
        if (newExpStackDTO.getStackId() != null) {
            Optional<Stack> stackOptional = stackRepository.findById(newExpStackDTO.getStackId());
            if (stackOptional.isEmpty()) {
                throw new RecordNotFoundException("Record not found");
            }
            expStack.setStack(stackOptional.get());
        }
        expStackRepository.save(expStack);
        ExpStackDTO expStackDTO = expStackMapper.modelToDto(expStack);
        expStackDTO.setExperienceId(expStack.getExperience().getId());
        expStackDTO.setStackId(expStack.getStack().getId());
        return expStackDTO;
    }

    @Override
    public void deleteExpStackData(Long id) throws RecordNotFoundException {
        Optional<ExpStack> expStackOptional = expStackRepository.findById(id);
        if (expStackOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        expStackRepository.deleteById(id);
    }

}
