package com.cbmke.cart.backend.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * An item in an order
 */
@Entity
public class LineItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private CustomerOrder customerOrder;
	
	@OneToOne
	private Item item;
	
	private int quantity;
	
	public Item getItem() {
		return item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Long getId() {
		return id;
	}
	
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
}
