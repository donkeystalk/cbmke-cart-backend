package com.cbmke.cart.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LineItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Order customerOrder;
	
	private int quantity;
	
	@OneToOne
	@JoinColumn(name="ITEM_ID")
	private Item item;
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Long getId() {
		return id;
	}
	
	public Order getCustomerOrder() {
		return customerOrder;
	}
	
	public void setCustomerOrder(Order customerOrder) {
		this.customerOrder = customerOrder;
	}
}
