package com.example.portfolio.service;

import com.example.portfolio.dto.StackDTO;
import com.example.portfolio.dto.StackSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;

public interface StackService {

    StackDTO saveStackData(StackSaveDTO newStackSaveDTO) throws RecordNotFoundException;

    StackDTO updateStackData(Long id, StackSaveDTO newStackSaveDTO) throws RecordNotFoundException;

    void deleteStackData(Long id) throws RecordNotFoundException;

}
