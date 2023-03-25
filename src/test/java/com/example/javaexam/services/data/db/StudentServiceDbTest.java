package com.example.javaexam.services.data.db;

import com.example.javaexam.models.Homework;
import com.example.javaexam.models.Student;
import com.example.javaexam.service.data.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentServiceDbTest {
    @Autowired
    StudentService studentService;
/*= new Student(1, "Test", "Student", LocalDate.of(2022, 2, 5), "PV228",null);*/
    @Autowired
    Student studEx;
    Student studAct;

    @Test
    void save() {

        studAct = studentService.save(studEx);
        assertEquals(studEx, studAct);
    }
/*
    @Test
    void testChangeStatus(){
        studAct = studentService.findById(1);
        studAct.getHomeworks().get(0).setStatus(Homework.Status.IN_PROGRESS);
        studentService.save(studAct);
        System.out.println(studentService.findById(2).getHomeworks().get(0));
    }*/
}
