package com.vinay7.Transactiondemo.repository;

import com.vinay7.Transactiondemo.entity.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecord, Long> {
}