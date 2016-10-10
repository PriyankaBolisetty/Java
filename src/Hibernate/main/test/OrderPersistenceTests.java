package com.orm.orders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.orm.orders.domain.GivenItem;
import com.orm.orders.domain.GivenOrder;



@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderPersistenceTests {

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	@Transactional
	public void testSaveOrderWithItems() throws Exception {
		org.hibernate.Session session = sessionFactory.getCurrentSession();
		GivenOrder order = new GivenOrder();
		order.getItems().add(new GivenItem());
		session.save(order);
		session.flush();
		assertNotNull(order.getId());
	}

	@Test
	@Transactional
	public void testSaveAndGet() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		GivenOrder order = new GivenOrder();
		order.getItems().add(new GivenItem());
		session.save(order);
		session.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		session.clear();
		GivenOrder other = (GivenOrder) session.get(GivenOrder.class, order.getId());
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

	@Test
	@Transactional
	public void testSaveAndFind() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		GivenOrder order = new GivenOrder();
		GivenItem item = new GivenItem();
		item.setProduct("foo");
		order.getItems().add(item);
		session.save(order);
		session.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		session.clear();
		GivenOrder other = (GivenOrder) session
				.createQuery( "select o from Order o join o.items i where i.product=:product")
				.setString("product", "foo").uniqueResult();
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

}
