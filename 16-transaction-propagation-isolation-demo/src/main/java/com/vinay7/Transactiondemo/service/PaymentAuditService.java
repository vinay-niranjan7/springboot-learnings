package com.vinay7.Transactiondemo.service;

import com.vinay7.Transactiondemo.entity.Order;
import com.vinay7.Transactiondemo.entity.PaymentAudit;
import com.vinay7.Transactiondemo.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {

    private PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository) {
        this.paymentAuditRepository = paymentAuditRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public void audit(Order order) {
        PaymentAudit paymentAudit = new PaymentAudit(order.getAmount(),order.getId(),true);
        paymentAuditRepository.save(paymentAudit);
    }
}
