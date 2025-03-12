package com.klinux.payment.processor;

import org.springframework.stereotype.Component;

import com.klinux.payment.PaymentProcessor;

@Component
public class PayPalProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal Payment of $" + amount);
    }
}
