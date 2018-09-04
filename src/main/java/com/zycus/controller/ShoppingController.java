package com.zycus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.DTO.OrderDetails;
import com.zycus.entity.Customer;
import com.zycus.entity.Product;
import com.zycus.service.ShoppingService;

@RestController
public class ShoppingController {
	
	@Autowired 
	private ShoppingService service ;
	
	@RequestMapping(value = "/newCustomer",method = RequestMethod.POST,consumes="application/json",produces="text/plain")
	public String newCustomer(@RequestBody Customer customer){
		service.newCustomer(customer);
		return "customer added";
	}
	
	
	@RequestMapping(value = "/newProduct",method = RequestMethod.POST,consumes="application/json",produces="text/plain")
	public String newProduct(@RequestBody Product product){
		service.newProduct(product);
		return "product added";
	}
	
	@RequestMapping(value = "/placeOrder",method = RequestMethod.POST,consumes="application/json",produces="text/plain")
	public String placeOrder(@RequestBody OrderDetails orderDetails){
		service.placeOrder(orderDetails);
		return "order placed ";
	}
	
	@RequestMapping(value = "/getCustomers",method = RequestMethod.GET,produces="application/json")
	public Iterable<Customer> getcustomers(){
		return service.getRegisteredCustomers();
		
	}
	
	@RequestMapping(value = "/getProducts",method = RequestMethod.GET,produces="application/json")
	public Iterable<Product> getProducts(){
		return service.getAvailableProducts();
		
	}
}
