package com.app.bikesharing.service;

import com.app.bikesharing.dto.BikeInsertDTO;
import com.app.bikesharing.dto.BikeUpdateDTO;
import com.app.bikesharing.model.Bike;
import com.app.bikesharing.model.User;

import java.util.List;

public interface BikeService {

    void addBike(BikeInsertDTO bikeInsertDTO);

    User findUserByEmail(String email);

    List<Bike> findBike(int id);

    void updateBike(BikeUpdateDTO bikeUpdateDTO);

    void deleteBike(int id);

}
