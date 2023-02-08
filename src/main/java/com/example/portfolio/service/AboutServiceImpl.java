package com.example.portfolio.service;

import com.example.portfolio.dto.AboutContentDTO;
import com.example.portfolio.dto.AboutDTO;
import com.example.portfolio.dto.AboutUpdateDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.mapper.AboutContentMapper;
import com.example.portfolio.mapper.AboutMapper;
import com.example.portfolio.model.About;
import com.example.portfolio.repository.AboutContentRepository;
import com.example.portfolio.repository.AboutRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutRepository aboutRepository;

    @Autowired
    private AboutContentRepository aboutContentRepository;

    @Autowired
    private AboutMapper aboutMapper;

    @Autowired
    private AboutContentMapper aboutContentMapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AboutDTO getAboutData() {
        About about = aboutRepository.findFirstByOrderByIdAsc();
        AboutDTO aboutDTO = aboutMapper.modelToDto(about);
        List<AboutContentDTO> aboutContentDTOList = aboutContentRepository.findAll()
                .stream()
                .map(aboutContentMapper::modelToDto)
                .toList();
        aboutDTO.setContentList(aboutContentDTOList);
        return aboutDTO;
    }

    @Override
    public AboutUpdateDTO updateAboutData(Long id, AboutUpdateDTO newAboutUpdateDTO) throws RecordNotFoundException {
        Optional<About> aboutOptional = aboutRepository.findById(id);
        if (aboutOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        About about = aboutOptional.get();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(newAboutUpdateDTO, about);
        aboutRepository.save(about);
        return aboutMapper.modelToUpdateDto(about);
    }

}
