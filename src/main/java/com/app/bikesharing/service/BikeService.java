package com.app.bikesharing.service;

import com.app.bikesharing.dto.BikeInsertDTO;

public interface BikeService {

    void addBike(BikeInsertDTO bikeInsertDTO);

    void updateBike(int id);

    void deleteBike(int id);

}
