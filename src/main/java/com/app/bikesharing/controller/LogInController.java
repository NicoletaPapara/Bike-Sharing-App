package com.app.bikesharing.controller;


import com.app.bikesharing.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogInController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "/error/access_denied";
    }

    @Autowired
    private LogInService logInService;

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
//    @PostMapping(value = "/login")
//    public ModelAndView validateLogin(LogInDTO logInDTO) throws InvalidDatesException {
//        ModelAndView modelAndView = new ModelAndView();
//        logInService.validateUser(logInDTO);
//
//         String email = logInDTO.getEmail();
//        modelAndView.addObject("home",email);
//        return modelAndView;
//    }

//    @GetMapping
//    public ModelAndView accessDenied() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("error/access_denied");
//
//        return model;
//    }
}
