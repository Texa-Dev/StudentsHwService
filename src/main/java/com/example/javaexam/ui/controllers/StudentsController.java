package com.example.javaexam.ui.controllers;

import com.example.javaexam.models.Homework;
import com.example.javaexam.models.Student;
import com.example.javaexam.service.data.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentsController {
    @Autowired
    StudentService studentService;

    @GetMapping("students")
    String load(Model model) {

        List<Student> list = studentService.findAll();
        model.addAttribute("students", list);
        return "students";
    }

      @PostMapping("studentHomeworks")
      ModelAndView homeworks(@RequestParam("id")Integer id){
        return new ModelAndView("redirect:homeworks",
                new ModelMap("id",id));
    }

       @GetMapping("homeworks")
    public String load(Model model, @RequestParam("id") Integer id) {
        Student student = studentService.findById(id);
        if (student.getHomeworks() != null) {
            List<Homework> homeworks = student.getHomeworks();
            model.addAttribute("homeworks", homeworks);
            return "homeworks";
        }
        model.addAttribute("homeworks", null);
        return "homeworks";
    }
}
