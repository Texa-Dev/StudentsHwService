package com.example.javaexam.ui.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

import static jakarta.servlet.RequestDispatcher.*;

@Controller
public class ErrController implements ErrorController {

    @RequestMapping(value = "error")
    public ModelAndView errHandle(HttpServletRequest request){
        Integer attr= (Integer) request.getAttribute(ERROR_STATUS_CODE);
        return new ModelAndView("error", new ModelMap().
                addAttribute("timespan", LocalDate.now()).
                addAttribute("error", request.getAttribute(ERROR_MESSAGE)).
                addAttribute("status", attr).
                addAttribute("path", ERROR_REQUEST_URI));
    }

}
