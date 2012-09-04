package com.cbmke.cart;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cbmke.cart.backend.entities.LineItem;
import com.cbmke.cart.backend.entities.CustomerOrder;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderPersistenceTests {

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	@Transactional
	public void testSaveOrderWithItems() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		CustomerOrder order = new CustomerOrder();
		LineItem li = new LineItem();
		li.setCustomerOrder(order);
		order.getItems().add(li);
		session.save(order);
		session.flush();
		Long id = order.getId();
		order = null;
		order = (CustomerOrder)session.createQuery("from CustomerOrder o where o.id=:id")
				.setLong("id", id).uniqueResult();
		assertNotNull(order.getId());
		assertEquals(1, order.getItems().size());
	}

	

}
