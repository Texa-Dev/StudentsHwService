package com.example.javaexam.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//Это взято с предидущего поекта
@Controller
public class MainController {

    @GetMapping("/")
    String load(){
        return "redirect:/students";
    }
}
