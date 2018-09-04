package com.zycus.repository;

import org.springframework.data.repository.CrudRepository;

import com.zycus.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
