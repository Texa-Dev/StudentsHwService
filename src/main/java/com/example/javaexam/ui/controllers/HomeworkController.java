package com.example.javaexam.ui.controllers;

import com.example.javaexam.models.Homework;
import com.example.javaexam.models.Student;
import com.example.javaexam.service.data.HomeworkService;
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
import java.util.Objects;

@Controller
public class HomeworkController {
    @Autowired
    HomeworkService homeworkService;
    @Autowired
    StudentService studentService;

    @PostMapping("homeworkDoing")
    ModelAndView homeworkDoing(@RequestParam("id") Integer id) {
        return new ModelAndView("redirect:doHomework",
                new ModelMap("id", id));
    }

    @GetMapping("doHomework")
    public String load(Model model, @RequestParam("id") Integer id) {
        Homework homework = homeworkService.findById(id);
        homework.setStatus(Homework.Status.IN_PROGRESS);
        homework = homeworkService.save(homework);
        model.addAttribute("homework", homework);
        return "doHomework";
    }


    //Метод сохранения или отправки домашнего задания
    @PostMapping("saveHomework")
    ModelAndView saveHomework(@RequestParam("id") Integer id, @RequestParam("text") String text,
                              @RequestParam("action") String action) {

        Homework homework = homeworkService.findById(id);
        homework.setText(text);
        if (Objects.equals(action, "save")) {
            homework = homeworkService.save(homework);
        } else if (Objects.equals(action, "send")) {
            homework.setStatus(Homework.Status.UNCHECKED);
            homework = homeworkService.save(homework);
        }
        homework.getStudent().setHomeworks(List.of(homework));

        return new ModelAndView("redirect:homeworks",
                new ModelMap("id", homework.getStudent().getId()));

    }


}
