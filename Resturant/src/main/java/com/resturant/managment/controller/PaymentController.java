package com.resturant.managment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resturant.management.service.PaymentService;

@RestController
public class PaymentController {
    
    @Autowired
    PaymentService paymentService;
    
    @PostMapping("/perfomPayment/{orderId}")
    public void perfomPayment(@PathVariable("orderId") Integer orderId) {
        paymentService.perfromPayment(orderId);
    }
}
