package com.realestatebackend.controller;

import com.realestatebackend.entity.AccountEntity;
import com.realestatebackend.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AccountEntity> findDepartmentById(@PathVariable @Min(0) Integer id) {
        AccountEntity entity = accountService.findAccountById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
