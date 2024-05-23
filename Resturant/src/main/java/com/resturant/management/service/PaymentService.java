package com.resturant.management.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturant.management.constant.StatusConstant;
import com.resturant.managment.entity.OrderedItem;
import com.resturant.managment.entity.Orders;
import com.resturant.managment.entity.Payment;
import com.resturant.managment.repository.OrderRepository;

@Service

public class PaymentService {
    
    @Autowired
    OrderRepository orderRepository;
    
    public void perfromPayment(Integer orderId) {
        Optional<Orders> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()) {
            Orders order = optionalOrder.get();
            Payment payment = new Payment();
            order.setPayment(payment);
            order.setStatus(StatusConstant.PAID);
            payment.setTotalPrice(order.getOrderedItems().stream().map(OrderedItem::getPrice).reduce(0.0D, Double::sum));
            orderRepository.save(order);
        }
    }
    
}