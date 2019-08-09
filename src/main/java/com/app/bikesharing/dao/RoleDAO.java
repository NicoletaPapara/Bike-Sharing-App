package com.app.bikesharing.dao;

import com.app.bikesharing.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository//To autowire the components
public interface RoleDAO extends  CrudRepository<Role, Integer> {
    public Role findByRole(String role);
}
