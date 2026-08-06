package com.vinay7.Transactiondemo.repository;

import com.vinay7.Transactiondemo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}