package com.example.portfolio.service;

import com.example.portfolio.dto.AboutContentDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.mapper.AboutContentMapper;
import com.example.portfolio.model.AboutContent;
import com.example.portfolio.repository.AboutContentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AboutContentServiceImpl implements AboutContentService {

    @Autowired
    private AboutContentRepository aboutContentRepository;

    @Autowired
    private AboutContentMapper aboutContentMapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AboutContentDTO saveAboutContentData(AboutContentDTO newAboutContentDTO) {
        AboutContent aboutContent = aboutContentRepository.save(aboutContentMapper.dtoToModel(newAboutContentDTO));
        return aboutContentMapper.modelToDto(aboutContent);
    }

    @Override
    public AboutContentDTO updateAboutContentData(Long id, AboutContentDTO newAboutContentDTO)
            throws RecordNotFoundException {
        Optional<AboutContent> aboutContentOptional = aboutContentRepository.findById(id);
        if (aboutContentOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        AboutContent aboutContent = aboutContentOptional.get();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(newAboutContentDTO, aboutContent);
        aboutContentRepository.save(aboutContent);
        return aboutContentMapper.modelToDto(aboutContent);
    }

    @Override
    public void deleteAboutContentData(Long id) throws RecordNotFoundException {
        Optional<AboutContent> aboutContentOptional = aboutContentRepository.findById(id);
        if (aboutContentOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        aboutContentRepository.deleteById(id);
    }

}
