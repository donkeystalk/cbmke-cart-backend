package com.cbmke.cart.backend.repos;

import java.util.List;

import com.cbmke.cart.backend.entities.Item;

public interface ItemRepository {
	public List<Item> findAllItems();
	public Item findItemById(Long id);
}
