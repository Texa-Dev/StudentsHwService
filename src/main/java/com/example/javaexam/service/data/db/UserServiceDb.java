package com.example.javaexam.service.data.db;

import com.example.javaexam.models.User;
import com.example.javaexam.repositories.UserRepository;
import com.example.javaexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDb implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User save(User userExp) {
        return userRepository.save(userExp);
    }
}
