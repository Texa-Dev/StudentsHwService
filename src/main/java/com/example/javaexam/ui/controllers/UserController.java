package com.example.javaexam.ui.controllers;

import com.example.javaexam.models.User;
import com.example.javaexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("users")
    String load(Model model) {

        List<User> list = userService.findAll();
        model.addAttribute("users", list);
        return "users";
    }
    //это неработает (так и не разобрался пока(вам в личку писал))
    @PostMapping("userUpdate")
    public String userUpdate(@RequestParam Integer id,
                             @RequestParam String userRole,
                             @RequestParam String userStatus) {
        System.out.println(id);
        User user = userService.findById(id);
        System.out.println(userRole);
        System.out.println(userStatus);
       /* user.setRole(role);
        user.setStatus(status);*/
        userService.save(user);
        return "redirect:users";
    }

}
