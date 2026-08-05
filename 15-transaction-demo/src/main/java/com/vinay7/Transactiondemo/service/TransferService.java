package com.vinay7.Transactiondemo.service;


import com.vinay7.Transactiondemo.entity.Account;
import com.vinay7.Transactiondemo.entity.TransferRecord;
import com.vinay7.Transactiondemo.repository.AccountRepository;
import com.vinay7.Transactiondemo.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService {
    private AccountRepository accountRepository;
    private TransferRepository transferRepository;

    public TransferService(AccountRepository accountRepository, TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }
    @Transactional
    public void transfer(Long fromAccountId,
                         Long toAccountId,
                         BigDecimal amount){
        if(fromAccountId.equals(toAccountId)){
            throw new RuntimeException("Accounts cannot be same");
        }

        Account fromAccount =
                accountRepository.findById(fromAccountId)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        Account toAccount =
                accountRepository.findById(toAccountId)
                        .orElseThrow(() -> new RuntimeException("User not found"));



        fromAccount.debitAccount(amount);

        toAccount.creditAccount(amount);

        transferRepository.save(new TransferRecord(
                fromAccountId,
                toAccountId,
                amount,
                LocalDate.now()
        ));

        //throw new RuntimeException("Some Error Occured");

    }
}
