package com.example.javaexam.repositories;

import com.example.javaexam.models.Teacher;
import com.example.javaexam.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherByUser(User user);
}
