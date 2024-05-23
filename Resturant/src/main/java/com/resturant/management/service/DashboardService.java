package com.resturant.management.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturant.management.constant.StatusConstant;
import com.resturant.managment.repository.OrderRepository;
import com.resturant.managment.repository.OrderedItemsRepository;

@Service
public class DashboardService {
    
    @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    OrderedItemsRepository orderedItemsRepository;
    
    public Map<String, String> getCounts() {
        Date todayDate = new Date();
        Map<String, String> counts = new HashMap<>();
        counts.put("TODAY_TOTAL_ORDER", String.valueOf(orderRepository.countAll(todayDate)));
        counts.put("TODAY_PAYMENT_PENDING_ORDERS", String.valueOf(orderRepository.countPaymentPendingOrder(todayDate, StatusConstant.OREDER_RECEIVED)));
        counts.put("TODAY_TOTAL_PAID_ADMOUNT", String.valueOf(orderRepository.totalPaidAmount(todayDate)));
        counts.put("TODAY_TOTAL_PAID_ORDER", String.valueOf(orderRepository.totalPaidOrders(todayDate, StatusConstant.PAID)));
        counts.put("TODAY_TOTAL_PENDING_AMOUNT", String.valueOf(orderedItemsRepository.totalPendingAmount(todayDate, StatusConstant.OREDER_RECEIVED)));
        return counts;
    }
    
}
