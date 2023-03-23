package com.example.javaexam.repositories;

import com.example.javaexam.models.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(@NonNull String username);
}
