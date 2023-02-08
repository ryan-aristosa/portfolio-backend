package com.example.portfolio.service;

import com.example.portfolio.dto.AboutDTO;
import com.example.portfolio.dto.AboutUpdateDTO;
import com.example.portfolio.exception.RecordNotFoundException;

public interface AboutService {

    AboutDTO getAboutData();

    AboutUpdateDTO updateAboutData(Long id, AboutUpdateDTO newAboutUpdateDTO) throws RecordNotFoundException;

}
