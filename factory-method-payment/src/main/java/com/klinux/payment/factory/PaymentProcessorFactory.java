package com.klinux.payment.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.klinux.payment.PaymentProcessor;
import com.klinux.payment.processor.CreditCardProcessor;
import com.klinux.payment.processor.PayPalProcessor;
import com.klinux.payment.processor.StripeProcessor;

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