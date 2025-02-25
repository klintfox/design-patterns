package com.klinux.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.klinux.payment.PaymentProcessor;
import com.klinux.payment.PaymentProcessorFactory;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @Mock
    private PaymentProcessorFactory paymentProcessorFactory;

    @Mock
    private PaymentProcessor mockPaymentProcessor;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void testProcessPayment_creditCard() {
        when(paymentProcessorFactory.getPaymentProcessor("creditcard")).thenReturn(mockPaymentProcessor);

        paymentService.processPayment("creditcard", 100.0);
        verify(mockPaymentProcessor).processPayment(100.0);
    }

    @Test
    public void testProcessPayment_payPal() {
        when(paymentProcessorFactory.getPaymentProcessor("paypal")).thenReturn(mockPaymentProcessor);

        paymentService.processPayment("paypal", 50.0);
        verify(mockPaymentProcessor).processPayment(50.0);
    }

    @Test
    public void testProcessPayment_stripe() {
        when(paymentProcessorFactory.getPaymentProcessor("stripe")).thenReturn(mockPaymentProcessor);

        paymentService.processPayment("stripe", 75.0);
        verify(mockPaymentProcessor).processPayment(75.0);
    }

    @Test
    public void testProcessPayment_invalidMethod() {
        when(paymentProcessorFactory.getPaymentProcessor("bitcoin")).thenThrow(new IllegalArgumentException("Unknown payment method: bitcoin"));

        try {
            paymentService.processPayment("bitcoin", 30.0);
        } catch (IllegalArgumentException e) {
            assert(e.getMessage().equals("Unknown payment method: bitcoin"));
        }
    }
}