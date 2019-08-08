package com.app.bikesharing.dao;

import com.app.bikesharing.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface RoleDAO extends  CrudRepository<Role, Integer> {
    public Role findByRole(String role);
}
