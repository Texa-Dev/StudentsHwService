package com.example.javaexam.service.data.db;

import com.example.javaexam.models.Teacher;
import com.example.javaexam.models.User;
import com.example.javaexam.repositories.TeacherRepository;
import com.example.javaexam.service.data.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceDb implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Override
    public Teacher save(Teacher teacherExp) {
        return teacherRepository.save(teacherExp);
    }

    @Override
    public Teacher findById(int id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public Teacher findTeacherByUser(User byUsername) {
        return teacherRepository.findTeacherByUser(byUsername);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
