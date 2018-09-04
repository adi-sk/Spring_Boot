package com.zycus.DTO;

import java.util.HashMap;
import java.util.Map;

public class OrderDetails {

	private int customerId;
	private Map<Integer, Integer> cart = new HashMap<Integer, Integer>();
	
	public OrderDetails(int customerId){
		this.customerId = customerId;
	}
	
	public void addToCart(int productId , int quantity){
		cart.put(productId, quantity);
	}
	
	public int getCutomerId() {
		return customerId;
	}
	public void setCutomerId(int customerId) {
		this.customerId = customerId;
	}
	public Map<Integer, Integer> getCart() {
		return cart;
	}
	public void setCart(Map<Integer, Integer> cart) {
		this.cart = cart;
	}
	
	
	
}
