package com.zycus.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="TBL_ORDERS")
public class Order {

	@Id
	private int id;
	private Date date;
	 
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	private Set<LineItem> lineItems;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	
}
