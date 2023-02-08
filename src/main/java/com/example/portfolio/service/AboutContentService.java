package com.example.portfolio.service;

import com.example.portfolio.dto.AboutContentDTO;
import com.example.portfolio.exception.RecordNotFoundException;

public interface AboutContentService {

    AboutContentDTO saveAboutContentData(AboutContentDTO newAboutContentDTO);

    AboutContentDTO updateAboutContentData(Long id, AboutContentDTO newAboutContentDTO) throws RecordNotFoundException;

}
