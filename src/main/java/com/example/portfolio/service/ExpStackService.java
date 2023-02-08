package com.example.portfolio.service;

import com.example.portfolio.dto.ExpStackDTO;
import com.example.portfolio.exception.RecordNotFoundException;

public interface ExpStackService {

    ExpStackDTO saveExpStackData(ExpStackDTO newExpStackDTO) throws RecordNotFoundException;

    ExpStackDTO updateExpStackData(Long id, ExpStackDTO newExpStackDTO) throws RecordNotFoundException;

    void deleteExpStackData(Long id) throws RecordNotFoundException;

}
