package com.vinay7.Transactiondemo.service;

import com.vinay7.Transactiondemo.entity.Account;
import com.vinay7.Transactiondemo.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account) {
        accountRepository.save(account);
    }
}