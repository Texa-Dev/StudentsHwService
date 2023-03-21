package com.example.javaexam.services.data;

import com.example.javaexam.models.Homework;
import com.example.javaexam.models.Student;
import com.example.javaexam.models.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ModelSource {

    @Bean
    public Student studentInst(){
        return new Student(1,"Doe","John", LocalDate.of(2006,3,5),"PV228",null);
    }
    @Bean
    public Teacher teacherInst(){
        return new Teacher(1,"Test","Teacher",null);
    }
    @Bean
    public Homework homeworkInst(){
        return new Homework(1,"What is OOP?","",LocalDate.now(),LocalDate.now().plusDays(10), Homework.Status.CREATED,null,null);
    }

}
