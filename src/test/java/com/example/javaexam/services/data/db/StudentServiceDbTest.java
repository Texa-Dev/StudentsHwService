package com.example.javaexam.services.data.db;

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

    Student studEx = new Student(1, "Test", "Student", LocalDate.of(2022, 2, 5), "PV228",null);
    Student studAct;

    @Test
    void save() {
        System.out.println(studEx);
        studAct = studentService.save(studEx);
        assertEquals(studEx, studAct);
    }
}
