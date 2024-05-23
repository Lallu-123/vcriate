package com.resturant.managment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.resturant.management.dto.LoginDto;
import com.resturant.management.service.UserAuthenticationService;

import jakarta.annotation.security.PermitAll;

@RestController
public class UserAuthenticationController {
    
    @Autowired
    UserAuthenticationService userAuthenticationService;

//    @PostMapping("/save")
//    public int saveUser(@RequestBody UserLogin user) {
//        userAuthenticationService.saveUser(user);
//        return user.getId();
//    }

    @PermitAll
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity authenticate(@RequestBody LoginDto loginDto) {
        return userAuthenticationService.authenticate(loginDto);
    }
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }

}
