package com.example.portfolio.service;

import com.example.portfolio.dto.AboutDTO;
import com.example.portfolio.dto.AboutUpdateDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.model.About;

public interface AboutService {

    AboutDTO getAboutData();

    AboutUpdateDTO updateAboutData(Long id, About newAbout) throws RecordNotFoundException;

}
