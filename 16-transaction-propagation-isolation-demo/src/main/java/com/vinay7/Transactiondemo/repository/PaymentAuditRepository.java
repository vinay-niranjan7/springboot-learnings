package com.vinay7.Transactiondemo.repository;

import com.vinay7.Transactiondemo.entity.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PaymentAuditRepository extends JpaRepository<PaymentAudit,Long> {
}
