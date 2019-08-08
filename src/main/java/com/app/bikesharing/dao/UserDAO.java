package com.app.bikesharing.dao;

import com.app.bikesharing.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
    public User findByEmail(String email);
}
