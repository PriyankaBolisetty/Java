package com.orm.orders.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orm.orders.domain.Product;

public class HibernateClient {
	public static void main(String args[]){
		
		ApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		SessionFactory sessionFactory = (SessionFactory)container.getBean("sessionFactory");
		
		Session session = null;
		Transaction tx = null;
		Product product = null;
		
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			product = new Product();
			product.setName("Cup cakes");
			product.setPrice(3.78);
			
			session.save(product);
			tx.commit();
			
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			System.out.println("****An Exception occurred: " + e.getMessage());
		} finally {
			session.close();
		}
		System.out.println(product);
	}
}
