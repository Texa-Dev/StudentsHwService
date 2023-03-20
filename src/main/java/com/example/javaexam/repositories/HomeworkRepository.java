package com.example.javaexam.repositories;

import com.example.javaexam.models.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkRepository extends JpaRepository<Homework,Integer> {
}
