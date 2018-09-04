package com.zycus.repository;

import org.springframework.data.repository.CrudRepository;

import com.zycus.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
