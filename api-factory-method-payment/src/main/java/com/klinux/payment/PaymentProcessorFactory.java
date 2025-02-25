package com.klinux.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessorFactory {

    @Autowired
    private CreditCardProcessor creditCardProcessor;

    @Autowired
    private PayPalProcessor payPalProcessor;

    @Autowired
    private StripeProcessor stripeProcessor;

    public PaymentProcessor getPaymentProcessor(String paymentMethod) {
        switch (paymentMethod.toLowerCase()) {
            case "creditcard":
                return creditCardProcessor;
            case "paypal":
                return payPalProcessor;
            case "stripe":
                return stripeProcessor;
            default:
                throw new IllegalArgumentException("Unknown payment method: " + paymentMethod);
        }
    }
}