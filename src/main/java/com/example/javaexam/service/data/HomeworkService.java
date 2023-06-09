package com.example.javaexam.service.data;

import com.example.javaexam.models.Homework;
import com.example.javaexam.models.Student;
import com.example.javaexam.models.Teacher;

import java.util.List;

public interface HomeworkService {
    Homework save(Homework homeworkExp);

    Homework findById(int id);

    List<Homework> findAllByTeacherAndStatus(Teacher teacher, Homework.Status status);

    List<Homework> findAllByStudentAndStatus(Student student, Homework.Status status);

    double getAverageGradeForStudent(Student student);
}
