package com.example.javaexam.service.data.db;

import com.example.javaexam.models.Homework;
import com.example.javaexam.models.Student;
import com.example.javaexam.models.Teacher;
import com.example.javaexam.repositories.HomeworkRepository;
import com.example.javaexam.service.data.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceDb implements HomeworkService {
    @Autowired
    HomeworkRepository homeworkRepository;

    @Override
    public Homework save(Homework homeworkExp) {
        return homeworkRepository.save(homeworkExp);
    }

    @Override
    public Homework findById(int id) {
        return homeworkRepository.findById(id).orElse(null);
    }

    @Override
    public List<Homework> findAllByTeacherAndStatus(Teacher teacher,Homework.Status status) {
        List<Homework> allByTeacherAndStatus = homeworkRepository.findAllByTeacherAndStatus(teacher,status);
        return allByTeacherAndStatus.size() > 0 ? allByTeacherAndStatus : null;
    }

    @Override
    public List<Homework> findAllByStudentAndStatus(Student student, Homework.Status status) {
        return homeworkRepository.findAllByStudentAndStatus(student,status);
    }
}
