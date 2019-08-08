package com.app.bikesharing.service;

import com.app.bikesharing.dao.LogInDAOInterface;
import com.app.bikesharing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class LogInService implements LogInServiceInterface{

    @Autowired
    private LogInDAOInterface loginDAO;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return loginDAO.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    }
}
