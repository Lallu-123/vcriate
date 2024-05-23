package com.resturant.management.utlity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {
    
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        
        String encode = passwordEncoder.encode("admin1");
        
        System.out.println("==>> " + passwordEncoder.encode("admin1"));
        
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        
        System.out.println("==>>" + bCryptPasswordEncoder.encode("admin1"));
    }
    
}

