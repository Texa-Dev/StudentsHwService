package com.example.javaexam.services.data.db;

import com.example.javaexam.models.Homework;
import com.example.javaexam.models.Student;
import com.example.javaexam.models.Teacher;
import com.example.javaexam.service.data.HomeworkService;
import com.example.javaexam.service.data.StudentService;
import com.example.javaexam.service.data.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TeacherServiceDbTest {
    @Autowired
    TeacherService teacherService;
    @Autowired
    HomeworkService homeworkService;
    @Autowired
    StudentService studentService;

    @Autowired
    Teacher teacherExp;
    Teacher teacherAct;

   /* @Test
    void save() {
        teacherAct = teacherService.save(teacherExp);
        assertEquals(teacherExp, teacherAct);
    }

    @Test
    void assignHw() {
        teacherAct = teacherService.findById(1);

        List<Student> list = studentService.findAll();
        for (Student student : list) {
            Homework hw = homeworkService.save(new Homework(0, "What the fuck?", "", LocalDate.now(),
                    LocalDate.now().plusDays(10),0, Homework.Status.ASSIGNED, teacherAct, student));
            student.setHomeworks(List.of(hw));
        }
        studentService.saveAll(list);
    }*/
}
