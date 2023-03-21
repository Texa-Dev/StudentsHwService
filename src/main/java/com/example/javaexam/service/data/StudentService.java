package com.example.javaexam.service.data;

import com.example.javaexam.models.Student;

import java.util.List;

public interface StudentService {
    Student save(Student studEx);

    List<Student> findAll();

    Student findById(Integer id);

    List<Student> saveAll(List<Student> list);
}
