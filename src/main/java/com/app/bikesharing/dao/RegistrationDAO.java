package com.app.bikesharing.dao;

import com.app.bikesharing.model.User;
import com.app.bikesharing.model.UserDetails;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationDAO extends CrudRepository <User, Integer> {

//Customize the methods by adding a method which maps each user to a userDetails object
    public UserDetails getUserDetailsByUserId(int userId);

    public User findRegisteredUserById(int userId);
}


