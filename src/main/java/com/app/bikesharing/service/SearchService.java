package com.app.bikesharing.service;

import com.app.bikesharing.dto.BikeOrderDto;
import com.app.bikesharing.exceptions.InvalidDatesException;
import com.app.bikesharing.model.Bike;

import java.util.List;

public interface SearchService {
    List<Bike> findAvailableBikes(BikeOrderDto bikeOrderDto) throws InvalidDatesException;
}
