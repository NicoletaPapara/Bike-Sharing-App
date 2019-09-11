package com.app.bikesharing.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogInController {

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "/error/access_denied";
    }


    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @GetMapping(value = "/home")
    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @PostMapping(value = "/logout")
    public ModelAndView logout() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/");

        return modelAndView;
    }
}
