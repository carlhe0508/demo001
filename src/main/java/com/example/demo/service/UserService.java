package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    public User getUserById(String userId);

    boolean addUser(User record);

    List<User> findAll();
}
