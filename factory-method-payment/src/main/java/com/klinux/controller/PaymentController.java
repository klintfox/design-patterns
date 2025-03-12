package com.klinux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klinux.service.PaymentService;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/processPayment")
    public String processPayment(@RequestParam String paymentMethod, @RequestParam double amount) {
        paymentService.processPayment(paymentMethod, amount);
        return "Payment processed via " + paymentMethod;
    }
}