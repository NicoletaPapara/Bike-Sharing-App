package com.app.bikesharing.service;

import com.app.bikesharing.model.User;

public interface LogInServiceInterface {

    User findUserByEmail(String email);

    void saveUser(User user);
}
