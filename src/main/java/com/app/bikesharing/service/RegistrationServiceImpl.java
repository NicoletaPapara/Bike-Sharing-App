package com.app.bikesharing.service;

import com.app.bikesharing.dao.RoleDAO;
import com.app.bikesharing.dao.UserDAO;
import com.app.bikesharing.model.Role;
import com.app.bikesharing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service//@Service spring annotation makes sure that the RegistrationService is instanciated only once for all autowired field
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
   private BCryptPasswordEncoder encoder;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public void saveUser(User user) {
    //Convert the password from String to BCrypt password encoder
        user.setPassword(encoder.encode(user.getPassword()));

        user.setStatus("VERIFIED");

        Role userRole= roleDAO.findByRole("CLIENT");

        user.setRoles(new HashSet<>(Arrays.asList(userRole)));


        userDAO.save(user);
       

    }

    @Override
    public boolean userIsRegistered(User user) {

        boolean userAlreadyExists = false;
        User existingUser = userDAO.findByEmail(user.getEmail());
        // If user is found in database, then then user already exists.
        if(existingUser != null){
            userAlreadyExists = true;
        }
        return userAlreadyExists;
    }



}
