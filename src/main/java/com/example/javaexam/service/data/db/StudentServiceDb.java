package com.example.javaexam.service.data.db;

import com.example.javaexam.models.Student;
import com.example.javaexam.repositories.StudentRepository;
import com.example.javaexam.service.data.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceDb implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student save(Student studEx) {
        return studentRepository.save(studEx);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Student> saveAll(List<Student> list) {
        return studentRepository.saveAll(list);
    }
}
