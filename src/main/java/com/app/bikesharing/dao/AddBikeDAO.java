package com.app.bikesharing.dao;

import com.app.bikesharing.model.Bike;
import com.app.bikesharing.model.BikeType;
import com.app.bikesharing.model.Size;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddBikeDAO extends CrudRepository<Bike, Integer> {

    List<Bike> findByTypeAndSize(BikeType type, Size size);

}
