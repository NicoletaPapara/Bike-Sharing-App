package com.app.bikesharing.service;

import com.app.bikesharing.dao.AddBikeDAO;
import com.app.bikesharing.dao.OrderDAO;
import com.app.bikesharing.dto.BikeOrderDto;
import com.app.bikesharing.dto.OrderDTO;
import com.app.bikesharing.exceptions.InvalidDatesException;
import com.app.bikesharing.exceptions.NoBikesFoundException;
import com.app.bikesharing.model.Bike;
import com.app.bikesharing.model.Order;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.app.bikesharing.exceptions.Codes.INVALID_DATES;
import static com.app.bikesharing.exceptions.Codes.NO_BIKES;

@Service
public class SearchServiceImpl implements SearchService {

    private Logger logger = Logger.getLogger("SearchServiceImpl");

    @Autowired
    private AddBikeDAO bikeRepository;

    @Autowired
    private OrderDAO orderDAO;

    private List<Bike> bikes;
    private List<Order> orders;


    public SearchServiceImpl(AddBikeDAO bikeRepository, OrderDAO orderDAO){
        this.bikeRepository = bikeRepository;
        this.orderDAO = orderDAO;
    }

    @Override
    public List<Bike> findAvailableBikes(BikeOrderDto bikeOrderDto) throws InvalidDatesException, NoBikesFoundException {

        LocalDate startDate = convertToLocalDate(bikeOrderDto.getStartDate());
        LocalDate endDate = convertToLocalDate(bikeOrderDto.getEndDate());

        if(endDate.isBefore(startDate)){
            throw new InvalidDatesException("End date cannot be before start date",INVALID_DATES);
        }

        if(bikeRepository.findByTypeAndSize(bikeOrderDto.getType(), bikeOrderDto.getSize()) == null) {
            throw new NoBikesFoundException("Could not find any bike of selected type and size", NO_BIKES);
        }


        bikes = bikeRepository.findByTypeAndSize(bikeOrderDto.getType(), bikeOrderDto.getSize());

        bikes = bikes.stream()
                .filter(bike -> isAvailable(bike, startDate, endDate))
                .collect(Collectors.toList());

        return bikes;
    }

    //pentru un anumit bike si perioada imi verifica cu toate order-urile deja inregistrate daca perioada pe care se vrea
    //inchirierea bike-ului se suprapune cu vreun order
    private boolean isAvailable(Bike bike, LocalDate startDate, LocalDate endDate) {

        orders = orderDAO.findByBikeId(bike.getId());
        for (Order order : orders) {
            if (doDatesOverlap(order.getStartDate(), order.getEndDate(), startDate, endDate)) {
                return false;
            }
        }
        return true;
    }

    //imi verifica daca doua perioade de timp se suprapun
    private boolean doDatesOverlap(LocalDate startDate, LocalDate endDate, LocalDate startDate1, LocalDate endDate1) {
        return (startDate.isAfter(startDate1.minusDays(1)) && startDate.isBefore(endDate1.plusDays(1))
                || (endDate.isAfter(startDate1.minusDays(1)) && endDate.isBefore(endDate1.plusDays(1))));
    }

    private LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void addNewOrder(OrderDTO orderDTO){
        Order order = convertOrderDTOintoOrder(orderDTO);
        orderDAO.save(order);
    }

    private Order convertOrderDTOintoOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setBikeId(orderDTO.getBikeId());
        order.setUserId(orderDTO.getOwnerId());
        order.setStartDate(convertToLocalDate(orderDTO.getStartDate()));
        order.setEndDate(convertToLocalDate(orderDTO.getEndDate()));
        return order;
    }
}
