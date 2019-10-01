package com.app.bikesharing.dao;

import com.app.bikesharing.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends CrudRepository<Order, Integer> {
    List<Order> findByBikeId(int id);

    @Override
    <S extends Order> S save(S s);
}
