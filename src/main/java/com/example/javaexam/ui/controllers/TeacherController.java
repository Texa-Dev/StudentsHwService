package com.example.javaexam.ui.controllers;

import com.example.javaexam.models.Homework;
import com.example.javaexam.models.Student;
import com.example.javaexam.models.Teacher;
import com.example.javaexam.models.User;
import com.example.javaexam.repositories.UserRepository;
import com.example.javaexam.service.data.HomeworkService;
import com.example.javaexam.service.data.StudentService;
import com.example.javaexam.service.data.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HomeworkService homeworkService;
    @Autowired
    StudentService studentService;

    @GetMapping("teacher")
    String load(Model model, Authentication authentication) {
        //незнаю насколько это правильно и можно использовать authentication в контроллере но это для того что-бы
        //учитель видел только свой аккаунт а Админ видел всех, для студентов тоже не успел сделать

        User user = userRepository.findByUsername(authentication.getName());
        List<Teacher> teachers = new ArrayList<>();

        if (user.getRole() == User.Role.TEACHER) {
            teachers.add(teacherService.findTeacherByUser(user));
        } else if (user.getRole() == User.Role.ADMIN) {
            teachers = teacherService.findAll();
        } else {
            return "redirect:students";
        }
        model.addAttribute("teachers", teachers);
        return "teacher";
    }

    @PostMapping("students")
    String students() {
        return "redirect:/students";
    }
//выдача заданий всем студентам
    @PostMapping("addNewHomework")
    String addNewHomework(@RequestParam("id") Integer id, @RequestParam("task") String task) {
        Teacher teacher = teacherService.findById(id);
        List<Student> all = studentService.findAll();

        all.forEach(student -> student.setHomeworks(List.of(homeworkService.save(new Homework(0, task, "", LocalDate.now(),
                LocalDate.now().plusDays(10), 0, Homework.Status.ASSIGNED, teacher, student)))));
        return "redirect:/teacher";
    }

    @PostMapping("viewHomeworks")
    ModelAndView viewHomeworks(@RequestParam("id") Integer id) {

        return new ModelAndView("redirect:teacherHomeworks",
                new ModelMap("id", id));
    }

 // список только не проверенный работ учителя
    @GetMapping("teacherHomeworks")
    String viewHomeworks(Model model, @RequestParam("id") Integer id) {
        Teacher teacher = teacherService.findById(id);
        List<Homework> allUnchecked = homeworkService.findAllByTeacherAndStatus(teacher, Homework.Status.UNCHECKED);
        model.addAttribute("uncheckedHomeworks", allUnchecked);
        return "teacherHomeworks";
    }

    @PostMapping("checkHomework")
    ModelAndView checkHomework(@RequestParam("id") Integer id) {
        System.out.println(id);
        return new ModelAndView("redirect:checkHomework",
                new ModelMap("id", id));
    }

    @GetMapping("checkHomework")
    String checkHomework(Model model, @RequestParam("id") Integer id) {
        Homework homework = homeworkService.findById(id);
        model.addAttribute("homework", homework);
        return "checkHomework";
    }

    //Оценка и завершение задания
    @PostMapping("completeHomework")
    String completeHomework(@RequestParam("id") Integer id, @RequestParam("grade") Integer grade) {
        Homework homework = homeworkService.findById(id);
        homework.setGrade(grade);
        homework.setStatus(Homework.Status.COMPLETE);
        homeworkService.save(homework);

        Student student = studentService.findById(homework.getStudent().getId());
        student.setAvgGrade(homeworkService.getAverageGradeForStudent(student));
        studentService.save(student);
        return "redirect:students";
    }
}

