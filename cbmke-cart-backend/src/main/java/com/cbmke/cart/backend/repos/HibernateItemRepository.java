package com.cbmke.cart.backend.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cbmke.cart.backend.entities.Item;

@Repository
public class HibernateItemRepository implements ItemRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Item> findAllItems() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Item>)session.createQuery("from Item").list();
	}

	@Transactional(readOnly=true)
	public Item findItemById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Item)session.createQuery("from Item i where i.id = :id").setLong("id", id).uniqueResult();
	}

}
