package com.main.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.order.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order,Integer>{

}
