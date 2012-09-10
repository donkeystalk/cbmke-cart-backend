package com.cbmke.cart.backend.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="ORDER_ID")
	private Collection<LineItem> lineItems = new ArrayList<LineItem>();

	public Long getId() {
		return id;
	}
	
	public Collection<LineItem> getLineItems() {
		return lineItems;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
