package com.app.bikesharing.dao;

import com.app.bikesharing.model.Bike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddBikeDAO extends CrudRepository<Bike, Integer> {

}
