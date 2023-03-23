package com.example.javaexam.repositories;

import com.example.javaexam.models.Homework;
import com.example.javaexam.models.Student;
import com.example.javaexam.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework,Integer> {
    List<Homework> findAllByTeacherAndStatus(Teacher teacher, Homework.Status status);
    List<Homework> findAllByStudentAndStatus(Student student, Homework.Status status);


}
