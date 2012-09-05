package com.cbmke.cart;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cbmke.cart.backend.entities.Item;
import com.cbmke.cart.backend.entities.LineItem;
import com.cbmke.cart.backend.entities.Order;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderPersistenceTests {

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	@Transactional
	public void testSaveOrderWithItems() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Order order = new Order();
		Item item = new Item();
		session.save(item);
		session.flush();
		session.clear();
		for(int i=0; i<100; i++)
		{
			LineItem li = new LineItem();
			li.setItem(item);
			li.setCustomerOrder(order);
			order.getLineItems().add(li);
		}
		session.save(order);
		session.flush();
		order.getLineItems().clear();
		session.save(order);
		session.flush();
		session.clear();
		Long id = order.getId();
		order = null;
		order = (Order)session.createQuery("from Order o where o.id=:id")
				.setLong("id", id).uniqueResult();
		List<LineItem> lineItems = session.createQuery("from LineItem").list();
		assertNotNull(order.getId());
		assertEquals(0, order.getLineItems().size());
	}

	

}
