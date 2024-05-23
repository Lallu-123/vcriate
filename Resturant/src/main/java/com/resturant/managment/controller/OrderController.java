package com.resturant.managment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resturant.management.dto.OrderDto;
import com.resturant.management.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    OrderService orderService;
    
    @PostMapping("/create")
    public void create(@RequestBody OrderDto orderDto) {
        orderService.create(orderDto);
    }
    
    @GetMapping("/getAll")
    public List<OrderDto> getAll() {
       return orderService.getAll();
    }
    
}
