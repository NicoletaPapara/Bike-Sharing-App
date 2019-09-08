package com.app.bikesharing.service;

import com.app.bikesharing.exceptions.InvalidDatesException;
import com.app.bikesharing.model.User;

public interface LogInServiceInterface {

    User findUserByEmail(String email) throws InvalidDatesException;

    boolean verifyPassword(User user, String password);
}
