package com.example.portfolio.service;

import com.example.portfolio.dto.ExpDescriptionSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;

public interface ExpDescriptionService {

    ExpDescriptionSaveDTO saveExpDescriptionData(ExpDescriptionSaveDTO newExpDescriptionSaveDTO)
            throws RecordNotFoundException;

    ExpDescriptionSaveDTO updateExpDescriptionData(Long id, ExpDescriptionSaveDTO newExpDescriptionSaveDTO)
            throws RecordNotFoundException;

    void deleteExpDescriptionData(Long id) throws RecordNotFoundException;

}
