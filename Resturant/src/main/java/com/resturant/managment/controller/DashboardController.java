package com.resturant.managment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resturant.management.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    
    @Autowired
    DashboardService dashboardService;
    @GetMapping("/data")
    public ResponseEntity<?> counts() {
        return ResponseEntity.ok(dashboardService.getCounts());
    }
    
    
}