package com.example.javaexam.ui.controllers;

import com.example.javaexam.models.Student;
import com.example.javaexam.models.Teacher;
import com.example.javaexam.models.User;
import com.example.javaexam.service.UserService;
import com.example.javaexam.service.data.StudentService;
import com.example.javaexam.service.data.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;

    @PostMapping("/registerUser")
    String registerUser(@ModelAttribute User user,
                        @RequestParam("name") String name,
                        @RequestParam("surname") String surname,
                        @RequestParam("birthDate") LocalDate birthDate) {
        System.out.println(user);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus(User.Status.ACTIVE);
        user = userService.save(user);
        if (user.getRole().name().equals("TEACHER")) {
            Teacher t = new Teacher(0, surname, name, birthDate, user, null);
            teacherService.save(t);
            return "redirect:/authorization";
        } else if (user.getRole().name().equals("STUDENT")) {
            Student s = new Student(0, surname, name, birthDate, "PV228", 0.0, user, null);
            studentService.save(s);
            return "redirect:/authorization";
        }
        return "redirect:/authorization";
    }
}
