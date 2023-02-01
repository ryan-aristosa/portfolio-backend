package com.example.portfolio.service;

import com.example.portfolio.dto.AboutContentSpecificDTO;
import com.example.portfolio.dto.AboutDTO;
import com.example.portfolio.dto.AboutSpecificDTO;
import com.example.portfolio.mapper.AboutContentMapper;
import com.example.portfolio.mapper.AboutMapper;
import com.example.portfolio.model.About;
import com.example.portfolio.repository.AboutContentRepository;
import com.example.portfolio.repository.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public AboutDTO getAboutData() {
        About about = aboutRepository.findFirstByOrderByIdAsc();
        AboutSpecificDTO aboutSpecificDTO = aboutMapper.modelToSpecificDto(about);
        AboutDTO aboutDTO = aboutMapper.specificDtoToDto(aboutSpecificDTO);
        Long aboutId = about.getId();
        List<AboutContentSpecificDTO> aboutContentResponseDTOList = aboutContentRepository.findByAboutId(aboutId)
                .stream()
                .map(aboutContentMapper::modelToSpecificDto)
                .toList();
        aboutDTO.setAboutContentList(aboutContentResponseDTOList);
        return aboutDTO;
    }

}
