package com.app.bikesharing.controller;


import com.app.bikesharing.dto.BikeInsertDTO;
import com.app.bikesharing.dto.BikeUpdateDTO;
import com.app.bikesharing.model.Bike;
import com.app.bikesharing.model.User;
import com.app.bikesharing.service.BikeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Log4j2
@Controller
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping(value = "/addBike")
    public ModelAndView addBike(@ModelAttribute MultipartFile multipartFile) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("addBike");

        return modelAndView;
    }

    @PostMapping(value = "/addBike")
    public ModelAndView addBikePost(@ModelAttribute BikeInsertDTO bikeInsertDTO) {

        String authenticatedEmailAddress = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = bikeService.findUserByEmail(authenticatedEmailAddress);
        bikeInsertDTO.setUserId(user.getId());
        bikeService.addBike(bikeInsertDTO);
        log.info("Bike inserted successfully");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @GetMapping(value = "/editBike")
    public ModelAndView findBike(@ModelAttribute MultipartFile multipartFile) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("editBike");

        return modelAndView;
    }

    @PostMapping(value = "/editBike")
    public ModelAndView updateBike(@ModelAttribute BikeUpdateDTO bikeUpdateDTO) {

        String authenticatedEmailAddress = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = bikeService.findUserByEmail(authenticatedEmailAddress);
        bikeUpdateDTO.setUserId(user.getId());

        bikeService.updateBike(bikeUpdateDTO);

        log.info("Bike updated successfully");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @GetMapping(value = "/listPersonalBikes")
    public ModelAndView userInfo() {

        User user = bikeService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Bike> bike = bikeService.findBike(user.getId());
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("bike", bike);

        return modelAndView;
    }

    @PostMapping(value = "/listPersonalBikes")
    public ModelAndView postUserInfo(Bike bike) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("bike", bike);
        modelAndView.setViewName("editBike");
        return modelAndView;
    }

    @GetMapping(value = "/bikeManagement")
    public ModelAndView bikeManagement() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("bikeManagement");

        return modelAndView;
    }
    @GetMapping(value = "/delete")
    public ModelAndView deleteABike() {

        User user = bikeService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Bike> bike = bikeService.findBike(user.getId());
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("bike", bike);

        return modelAndView;
    }
    @PostMapping(value = "/delete")
    public ModelAndView delete(Bike bike) {

        ModelAndView modelAndView = new ModelAndView();
        bikeService.deleteBike(bike.getId());
        modelAndView.setViewName("home");

        return modelAndView;
    }
}
