package com.zycus.service;

import com.zycus.DTO.OrderDetails;
import com.zycus.entity.Customer;
import com.zycus.entity.Product;

public interface ShoppingService {

	void newCustomer(Customer customer);

	void newProduct(Product product);

	void placeOrder(OrderDetails orderDetails);
	
	Iterable<Customer> getRegisteredCustomers();
	
	Iterable<Product> getAvailableProducts();

}