package com.zycus.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zycus.DTO.OrderDetails;
import com.zycus.entity.Customer;
import com.zycus.entity.LineItem;
import com.zycus.entity.Order;
import com.zycus.entity.Product;
import com.zycus.repository.CustomerRepository;
import com.zycus.repository.OrderRepository;
import com.zycus.repository.ProductRepository;

@Service
@Transactional
public class ShoppingServiceImp1 implements ShoppingService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;
	

	@CacheEvict(value="customers.cache" , allEntries = true)
	public void newCustomer(Customer customer){
		customerRepository.save(customer);
	}
	
	@CacheEvict(value="products.cache" , allEntries = true)
	public void newProduct(Product product){
		productRepository.save(product);
	}
	
	@Cacheable(value = "customer.cache")
	public Iterable<Customer> getRegisteredCustomers(){
		
		return customerRepository.findAll();
	}
	
	@Cacheable(value = "products.cache")
	public Iterable<Product> getAvailableProducts(){
		return productRepository.findAll();
	}
	
	public void placeOrder(OrderDetails orderDetails){
		int customerId = orderDetails.getCutomerId();
		Map<Integer, Integer> cart = orderDetails.getCart();
	
		Customer customer = customerRepository.findById(customerId).get();
		
		Order order = new Order();
		order.setCustomer(customer);
		order.setDate(new Date());
		
		Set<LineItem> lineItems = new HashSet<LineItem>();
		for (Map.Entry<Integer, Integer> entry : cart.entrySet())
		{
		    int productId = entry.getKey();
		    int quantity = entry.getValue();
		    
		    Product product = productRepository.findById(productId).get();
		    product.setQuantity(product.getQuantity() - quantity);
		    productRepository.save(product);
		    
		    LineItem lineItem = new LineItem();
		    lineItem.setOrder(order);
		    lineItem.setProduct(product);
		    lineItem.setQuantity(quantity);
		    lineItems.add(lineItem);
		}
		
		order.setLineItems(lineItems);
		orderRepository.save(order);
	}
	
}
