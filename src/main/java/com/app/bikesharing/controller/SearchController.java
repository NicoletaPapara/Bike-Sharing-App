package com.app.bikesharing.controller;

import com.app.bikesharing.dto.BikeOrderDto;
import com.app.bikesharing.exceptions.InvalidDatesException;
import com.app.bikesharing.model.Bike;
import com.app.bikesharing.service.SearchService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {

    private List<Bike> bikes;
    Logger logger =Logger.getLogger("SearchController");

    @Autowired
    private SearchService searchService;


    @GetMapping(value = "/searchBike")
    public String searchBike(Model model) {
        model.addAttribute("bikeOrderDto", new BikeOrderDto());
        return "searchBike";
    }

    @PostMapping(value = "/searchBike")
    public String searchSubmit(Model model, @ModelAttribute("bikeOrderDto") BikeOrderDto bikeOrderDto) {
        try {
            bikes = searchService.findAvailableBikes(bikeOrderDto);
        } catch (InvalidDatesException e) {
            logger.error(e.getLocalizedMessage() + ":" + e.getCode());
        }
         model.addAttribute("bikes", bikes);
        return "listBikes";
    }

    @PostMapping(value = "/selectBike")
    public String selectBike(Model model, @ModelAttribute("bikeTwo") Bike bike) {
        // find owner by bike id
        //add a new order
        return "ownerDetails";
    }


}
