package com.example.javaexam.ui.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Это взято с предидущего поекта
@Controller
public class LogoutController {
    @GetMapping("logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (authentication != null) {
            System.out.println(authentication.isAuthenticated());
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "redirect:";
    }
}
