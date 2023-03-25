package com.example.javaexam.services.data;

import com.example.javaexam.models.Homework;
import com.example.javaexam.models.Student;
import com.example.javaexam.models.Teacher;
import com.example.javaexam.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ModelSource {

    @Bean
    public Student studentInst(){
        return new Student(1,"Doe","John", LocalDate.of(2006,3,5),"PV228",0.0,null,null);
    }
    @Bean
    public Teacher teacherInst(){
        return new Teacher(1,"tea","tea",null,null,null);
    }
    @Bean
    public Homework homeworkInst(){
        return new Homework(1,"What is OOP?","",LocalDate.now(),LocalDate.now().plusDays(10),0, Homework.Status.CREATED,null,null);
    }
    @Bean
    public User userInstance(BCryptPasswordEncoder encoder) {
        String pass = encoder.encode("test");
        User user = new User(1, "testT", pass, "tea@mail.com");
        user.setStatus(User.Status.ACTIVE);
        user.setRole(User.Role.TEACHER);
        return user;
    }

}
