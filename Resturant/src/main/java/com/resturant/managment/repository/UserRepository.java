package com.resturant.managment.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.resturant.managment.entity.UserLogin;

public interface UserRepository extends CrudRepository<UserLogin, Integer> {
    public Optional<UserLogin> findByUsername(String username);
}
