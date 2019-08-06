package com.app.bikesharing.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogInController {

    @GetMapping(value = {"/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return  modelAndView;
    }

    @GetMapping
    public ModelAndView accessDenied(){
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");

        return model;
    }
}
