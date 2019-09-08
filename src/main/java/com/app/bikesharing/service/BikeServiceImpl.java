package com.app.bikesharing.service;

import com.app.bikesharing.dao.AddBikeDAO;
import com.app.bikesharing.dao.UserDAO;
import com.app.bikesharing.dto.BikeInsertDTO;
import com.app.bikesharing.dto.BikeUpdateDTO;
import com.app.bikesharing.model.Bike;
import com.app.bikesharing.model.BikeType;
import com.app.bikesharing.model.Size;
import com.app.bikesharing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private AddBikeDAO addBikeDAO;
    @Autowired
    private UserDAO userDAO;

    public BikeServiceImpl(AddBikeDAO addBikeDAO) {
        this.addBikeDAO = addBikeDAO;
    }

    public Bike transformBikeInsertDTOIntoBike(BikeInsertDTO bikeInsertDTO) {

        MultipartFile multipartFile = bikeInsertDTO.getImage();

        byte[] image = null;
        try {
            if (multipartFile.getBytes().length > 1) {
                image = multipartFile.getBytes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int userId = bikeInsertDTO.getUserId();
        BikeType type = bikeInsertDTO.getType();
        Size size = bikeInsertDTO.getSize();
        double price = bikeInsertDTO.getPrice();

        Bike bike = new Bike();

        bike.setImage(image);
        bike.setUserId(userId);
        bike.setPrice(price);
        bike.setSize(size);
        bike.setType(type);

        return bike;
    }
    public Bike transformBikeUpdateDTOIntoBike(BikeUpdateDTO bikeUpdateDTO) {

        MultipartFile multipartFile = bikeUpdateDTO.getImage();

        byte[] image = null;
        try {
            if (multipartFile.getBytes().length > 1) {
                image = multipartFile.getBytes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int id = bikeUpdateDTO.getId();
        int userId = bikeUpdateDTO.getUserId();
        BikeType type = bikeUpdateDTO.getType();
        Size size = bikeUpdateDTO.getSize();
        double price = bikeUpdateDTO.getPrice();

        Bike bike = new Bike();

        bike.setId(id);
        bike.setImage(image);
        bike.setUserId(userId);
        bike.setPrice(price);
        bike.setSize(size);
        bike.setType(type);

        return bike;
    }

    @Override
    public void addBike(BikeInsertDTO bikeInsertDTO) {

        Bike bike = transformBikeInsertDTOIntoBike(bikeInsertDTO);
        addBikeDAO.save(bike);

    }
    @Override
    public User findUserByEmail (String email){
        return userDAO.findByEmail(email);

    }
    @Override
    public List<Bike> findBike(int id) {
        return addBikeDAO.findByUserId(id);
    }

    @Override
    public void updateBike(BikeUpdateDTO bikeUpdateDTO) {

        Bike bike = transformBikeUpdateDTOIntoBike(bikeUpdateDTO);

        addBikeDAO.save(bike);
    }

    @Override
    public void deleteBike(int id) {

    }
}
