package com.app.bikesharing.controller;

import com.app.bikesharing.dao.AddBikeDAO;
import com.app.bikesharing.dao.OrderDAO;
import com.app.bikesharing.dto.BikeOrderDto;
import com.app.bikesharing.dto.OrderDTO;
import com.app.bikesharing.exceptions.InvalidDatesException;
import com.app.bikesharing.exceptions.NoAvailableBikesException;
import com.app.bikesharing.exceptions.NoBikesFoundException;
import com.app.bikesharing.model.Bike;
import com.app.bikesharing.model.User;
import com.app.bikesharing.service.BikeService;
import com.app.bikesharing.service.SearchService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class SearchController {

    private List<Bike> bikes;
    private Logger logger = Logger.getLogger("SearchController");


    private String errorMessage =null;

    @Autowired
    private SearchService searchService;

    @Autowired
    private BikeService bikeService;

    @Autowired
    private AddBikeDAO bikeDAO;

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
            errorMessage = e.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            logger.error(e.getLocalizedMessage() + ":" + e.getCode());
        } catch (NoBikesFoundException e) {
            errorMessage = e.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            logger.error(e.getLocalizedMessage() + ":" + e.getCode());
        }catch (NoAvailableBikesException e){
            errorMessage = e.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            logger.error(e.getLocalizedMessage() + ":" + e.getCode());
        }
        model.addAttribute("bikes", bikes);
        model.addAttribute("startDate", bikeOrderDto.getStartDate());
        model.addAttribute("endDate", bikeOrderDto.getEndDate());
        return "listBikes";
    }

    @GetMapping(value = "/image/{id}")
    public void showBikeImage(@PathVariable int id, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        Bike bike = bikeDAO.findById(id);
        byte[] imageData = bike.getImage();
        OutputStream out = response.getOutputStream();
        out.write(imageData);
    }


    @PostMapping(value = "/selectBike")
    public String selectBike(Model model,
                             @ModelAttribute("orderDTO") OrderDTO orderDTO) {
        String authenticatedEmailAddress = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = bikeService.findUserByEmail(authenticatedEmailAddress);
        orderDTO.setOwnerId(user.getId());
        searchService.addNewOrder(orderDTO);
        model.addAttribute("owner", user);
        return "ownerDetails";
    }


}
