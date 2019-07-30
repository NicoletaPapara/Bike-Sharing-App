package com.app.bikesharing.service;

import com.app.bikesharing.dao.RegistrationDAO;
import com.app.bikesharing.dto.RegistrationDTO;
import com.app.bikesharing.model.User;
import com.app.bikesharing.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service//@Service spring annotation makes sure that the RegistrationService is instanciated only once for all autowired field
public class RegistrationService {

    @Autowired//injects dependency
    private RegistrationDAO registrationDAO;



    public void registerNewUser(User user) {

        registrationDAO.save(user);
    }

    public void updateRegisteredUser(int id, User user) {

        registrationDAO.save(user);
    }

    public void unregisterUser(int id) {
        //Before removing:
        // Validate, id, email, and password

        registrationDAO.deleteById(id);
    }

    public User findRegisteredUserById(int id) {
        //Validate to see if id is there. maybe use
        // Optional isPresent

        Optional<User> userOptional = registrationDAO.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            return user;
        }
        else{
            // throw validation exception....
        }

        return null;

    }

    public List<RegistrationDTO> getAllRegisteredUsers() {
       List<RegistrationDTO> users=new ArrayList<>();

       //here query the database once it is created get the dao and put it into the dto!!!
       RegistrationDTO newUser=new RegistrationDTO();


       users.add(newUser);


        return users;
    }

    public UserDetails findUserDetailsByUserId (int userId){

        return registrationDAO.getUserDetailsByUserId(userId);

    }

}
