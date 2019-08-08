package com.app.bikesharing.service;

import com.app.bikesharing.model.User;

public interface RegistrationService {

     void saveUser(User user);
     boolean userIsRegistered(User user);
}
