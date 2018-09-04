package com.zycus.repository;

import org.springframework.data.repository.CrudRepository;

import com.zycus.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
