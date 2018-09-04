package com.zycus.client;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.zycus.entity.Customer;

public class ShoppingClient {

	@Test
	public void addCustomer(String[] args){
		//add new customer
		
		Customer customer = new Customer();
		customer.setId(3);
		customer.setName("Aditya K");
		customer.setEmail("adi@gmail.com");
		
		//for accessing REST Services
		String url = "http://localhost:8090/newCustomer";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(url, customer, String.class);
		
		System.out.println(response.getBody());
	}
	
	@Test
	public void getCustomers(){
		String url = "http://localhost:8090/getCustomers";
		RestTemplate restTemplate = new RestTemplate();
		/*ResponseEntity<[]> response = restTemplate.getForEntity(url,Customer[].class);*/
		
		
		
	}
}
