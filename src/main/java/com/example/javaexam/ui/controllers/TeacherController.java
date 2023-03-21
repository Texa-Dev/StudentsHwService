package com.example.javaexam.ui.controllers;

import com.example.javaexam.models.Homework;
import com.example.javaexam.models.Student;
import com.example.javaexam.models.Teacher;
import com.example.javaexam.service.data.HomeworkService;
import com.example.javaexam.service.data.StudentService;
import com.example.javaexam.service.data.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    HomeworkService homeworkService;
    @Autowired
    StudentService studentService;

    @GetMapping("teacher")
    String load(Model model) {

        Teacher teacher = teacherService.findById(1);
        model.addAttribute("teacher", teacher);
        return "teacher";
    }

    @PostMapping("students")
    String students() {
        return "redirect:/students";
    }

    @PostMapping("addNewHomework")
    String addNewHomework(@RequestParam("id") Integer id, @RequestParam("task") String task) {
        Teacher teacher = teacherService.findById(id);
        List<Student> all = studentService.findAll();

        all.forEach(student ->{
            student.setHomeworks(List.of(homeworkService.save(new Homework(0, task, "", LocalDate.now(),
                    LocalDate.now().plusDays(10), Homework.Status.ASSIGNED, teacher, student))));
            /*if (student.getHomeworks()==null) {
                student.setHomeworks(List.of(homeworkService.save(new Homework(0, task, "", LocalDate.now(),
                        LocalDate.now().plusDays(10), Homework.Status.ASSIGNED, teacher, student))));
            }else student.getHomeworks().add(homeworkService.save(new Homework(0, task, "", LocalDate.now(),
                    LocalDate.now().plusDays(10), Homework.Status.ASSIGNED, teacher, student)));*/
        });
        return "redirect:/teacher";
    }
}
