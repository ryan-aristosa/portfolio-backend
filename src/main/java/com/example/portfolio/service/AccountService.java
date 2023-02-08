package com.example.portfolio.service;

import com.example.portfolio.dto.AccountSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;

public interface AccountService {

    AccountSaveDTO saveAccountData(AccountSaveDTO newAccountSaveDTO) throws RecordNotFoundException;

    AccountSaveDTO updateAccountData(Long id, AccountSaveDTO newAccountSaveDTO) throws RecordNotFoundException;

    void deleteAccountData(Long id) throws RecordNotFoundException;

}
