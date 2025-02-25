package com.klinux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klinux.payment.PaymentProcessor;
import com.klinux.payment.PaymentProcessorFactory;

@Service
public class PaymentService {

    @Autowired
    private PaymentProcessorFactory paymentProcessorFactory;

    public void processPayment(String paymentMethod, double amount) {
        PaymentProcessor processor = paymentProcessorFactory.getPaymentProcessor(paymentMethod);
        processor.processPayment(amount);
    }
}