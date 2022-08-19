package com.realestatebackend.service;

import com.realestatebackend.customexception.NoSuchEntityException;
import com.realestatebackend.entity.AccountEntity;
import com.realestatebackend.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountEntity findAccountById(Integer id)
    {
        Optional<AccountEntity> accountEntityOptional = accountRepository.findAccountEntityById(id);
        AccountEntity accountEntity = accountEntityOptional.orElseThrow(() -> new NoSuchEntityException("Not found account"));
        return accountEntity;

    }
}
