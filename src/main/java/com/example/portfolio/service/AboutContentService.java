package com.example.portfolio.service;

import com.example.portfolio.dto.AboutContentDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.model.AboutContent;

public interface AboutContentService {

    AboutContentDTO saveAboutContentData(AboutContent newAboutContent);

    AboutContentDTO updateAboutContentData(Long id, AboutContent newAboutContent) throws RecordNotFoundException;

}
