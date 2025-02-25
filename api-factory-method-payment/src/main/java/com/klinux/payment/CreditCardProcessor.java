package com.klinux.payment;

import org.springframework.stereotype.Component;

@Component
public class CreditCardProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment of $" + amount);
    }
}
