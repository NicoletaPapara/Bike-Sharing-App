package com.app.bikesharing.controller;


import com.app.bikesharing.dto.BikeInsertDTO;
import com.app.bikesharing.dto.BikeUpdateDTO;
import com.app.bikesharing.dto.UserInfoDTO;
import com.app.bikesharing.model.Bike;
import com.app.bikesharing.model.User;
import com.app.bikesharing.service.BikeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView addBikePost(@ModelAttribute BikeInsertDTO bikeInsertDTO ) {


        bikeService.addBike(bikeInsertDTO);

        log.info("Bike inserted successfully");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addBike");

        return modelAndView;
    }
    @GetMapping(value ="/editBike")
    public ModelAndView findBike(@ModelAttribute MultipartFile multipartFile) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("editBike");

        return modelAndView;
    }
    @PostMapping(value = "/editBike")
    public ModelAndView updateBike(@ModelAttribute BikeUpdateDTO bikeUpdateDTO) {


        bikeService.updateBike(bikeUpdateDTO);

        log.info("Bike updated successfully");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editBike");

        return modelAndView;
    }
    @GetMapping(value = "/userEmail")
    public ModelAndView userInfo(@ModelAttribute UserInfoDTO userInfoDTO){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("userInfo",userInfoDTO);

        return modelAndView;
    }
    @PostMapping(value = "/userEmail")
    public ModelAndView postUserInfo(@ModelAttribute UserInfoDTO userInfoDTO){

       User user = bikeService.findUserByEmail(userInfoDTO.getEmail());
       List<Bike> bike = bikeService.findBike(user.getId());
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("userInfo", bike);

        return modelAndView;
    }
}
