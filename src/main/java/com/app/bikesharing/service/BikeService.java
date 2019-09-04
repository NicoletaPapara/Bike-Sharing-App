package com.app.bikesharing.service;

import com.app.bikesharing.dto.BikeInsertDTO;
import com.app.bikesharing.dto.BikeUpdateDTO;

public interface BikeService {

    void addBike(BikeInsertDTO bikeInsertDTO);

    void findBike(int id);

    void updateBike(BikeUpdateDTO bikeUpdateDTO);

    void deleteBike(int id);

}
