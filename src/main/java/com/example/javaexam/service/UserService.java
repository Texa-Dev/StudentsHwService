package com.example.javaexam.service;

import com.example.javaexam.models.User;

import java.util.List;

public interface UserService {
    User save(User userExp);

    List<User> findAll();
}
