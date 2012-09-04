package com.cbmke.cart.backend.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * An order.
 */
@Entity
public class CustomerOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="customerOrder", cascade=CascadeType.ALL)
	private Collection<LineItem> items = new ArrayList<LineItem>();

	public Long getId() {
		return id;
	}
	
	public Collection<LineItem> getItems() {
		return items;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
