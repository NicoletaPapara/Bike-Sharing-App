package com.app.bikesharing.service;

import com.app.bikesharing.dao.AddBikeDAO;
import com.app.bikesharing.dto.BikeInsertDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
   private AddBikeDAO addBikeDAO;

   public BikeServiceImpl (AddBikeDAO addBikeDAO){
       this.addBikeDAO = addBikeDAO;
   }



    @Override
    public void addBike(BikeInsertDTO bikeInsertDTO) {
//        addBikeDAO.save(bikeInsertDTO);

    }

    @Override
    public void updateBike(int id) {

    }

    @Override
    public void deleteBike(int id) {

    }
}
