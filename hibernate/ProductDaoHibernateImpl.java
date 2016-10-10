package com.orm.orders.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orm.orders.dao.ProductDAO;
import com.orm.orders.domain.Product;

@Repository("productDaoHibernate")
@Transactional(readOnly = true)
public class ProductDaoHibernateImpl implements ProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertAProduct(Product product){
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
	}
}
