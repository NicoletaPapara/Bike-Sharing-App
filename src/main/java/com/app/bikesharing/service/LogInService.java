package com.app.bikesharing.service;

import com.app.bikesharing.dao.LogInDAOInterface;
import com.app.bikesharing.dto.LogInDTO;
import com.app.bikesharing.exceptions.InvalidDatesException;
import com.app.bikesharing.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.app.bikesharing.exceptions.Codes.INVALID_DATES;


@Service
public class LogInService implements LogInServiceInterface {

    @Autowired
    private LogInDAOInterface loginDAO;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Logger logger = Logger.getLogger("LogInService");

    public void validateUser(LogInDTO logInDTO) throws InvalidDatesException {
        User user = findUserByEmail(logInDTO.getEmail());
        if (!verifyPassword(user, logInDTO.getPassword())) {
            throw new InvalidDatesException("End date cannot be before start date",INVALID_DATES);
        }
    }

    @Override
    public User findUserByEmail(String email) throws InvalidDatesException {
        if (loginDAO.findByEmail(email)==null){
    throw new InvalidDatesException("user unregistered",INVALID_DATES);
        }
        return loginDAO.findByEmail(email);
    }

    @Override
    public boolean verifyPassword(User user, String password) {
        return bCryptPasswordEncoder.matches(password, user.getPassword());
    }
}
