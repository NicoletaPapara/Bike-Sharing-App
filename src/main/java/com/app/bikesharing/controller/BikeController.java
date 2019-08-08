package com.app.bikesharing.controller;


import com.app.bikesharing.dto.BikeInsertDTO;
import com.app.bikesharing.service.BikeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Log4j2
@Controller
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @PostMapping(value = "/add")
    public ModelAndView addBike(@ModelAttribute BikeInsertDTO bikeInsertDTO) {

        bikeService.addBike(bikeInsertDTO);

        log.info("Bike inserted successfully");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }
}
