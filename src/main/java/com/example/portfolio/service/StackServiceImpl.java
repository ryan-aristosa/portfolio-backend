package com.example.portfolio.service;

import com.example.portfolio.dto.StackDTO;
import com.example.portfolio.dto.StackSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.mapper.StackMapper;
import com.example.portfolio.model.FontColor;
import com.example.portfolio.model.Stack;
import com.example.portfolio.repository.FontColorRepository;
import com.example.portfolio.repository.StackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StackServiceImpl implements StackService {

    @Autowired
    private StackRepository stackRepository;

    @Autowired
    private FontColorRepository fontColorRepository;

    @Autowired
    private StackMapper stackMapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public StackDTO saveStackData(StackSaveDTO newStackSaveDTO) throws RecordNotFoundException {
        Optional<FontColor> fontColorOptional = fontColorRepository.findById(newStackSaveDTO.getFontColorId());
        if (fontColorOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        FontColor fontColor = fontColorOptional.get();
        Stack stack = stackMapper.saveDtoToModel(newStackSaveDTO);
        stack.setFontColor(fontColor);
        StackDTO stackDTO = stackMapper.modelToDto(stackRepository.save(stack));
        stackDTO.setFontColorCode(fontColor.getColorCode());
        return stackDTO;
    }

    @Override
    public StackDTO updateStackData(Long id, StackSaveDTO newStackSaveDTO) throws RecordNotFoundException {
        Optional<Stack> stackOptional = stackRepository.findById(id);
        if (stackOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Stack stack = stackOptional.get();
        if (newStackSaveDTO.getFontColorId() != null) {
            Optional<FontColor> fontColorOptional = fontColorRepository.findById(newStackSaveDTO.getFontColorId());
            if (fontColorOptional.isEmpty()) {
                throw new RecordNotFoundException("Record not found");
            }
            stack.setFontColor(fontColorOptional.get());
        }
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(newStackSaveDTO, stack);
        stackRepository.save(stack);
        StackDTO stackDTO = stackMapper.modelToDto(stack);
        stackDTO.setFontColorCode(stack.getFontColor().getColorCode());
        return stackDTO;
    }

    @Override
    public void deleteStackData(Long id) throws RecordNotFoundException {
        Optional<Stack> stackOptional = stackRepository.findById(id);
        if (stackOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        stackRepository.deleteById(id);
    }

}
