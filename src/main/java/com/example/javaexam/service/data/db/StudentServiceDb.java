package com.example.javaexam.service.data.db;

import com.example.javaexam.models.Student;
import com.example.javaexam.repositories.StudentRepository;
import com.example.javaexam.service.data.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceDb implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student save(Student studEx) {
        return studentRepository.save(studEx);
    }
}
