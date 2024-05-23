package com.resturant.management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.resturant.managment.entity.UserLogin;
import com.resturant.managment.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserLogin loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserLogin> findByUsername = userRepository.findByUsername(username);
        return findByUsername.orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
