package com.app.bikesharing.dao;

import com.app.bikesharing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogInDAOInterface extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
