package com.jobs.gethired.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.jobs.gethired.domain.Order;
import com.jobs.gethired.domain.OrderItem;
import com.jobs.gethired.domain.Product;

@Service
public class OrderServiceImpl implements OrderService{
	
	private List<Order> orderList;
	
	@PostConstruct
	public void initMockDataStructures(){
		initOrderList();
	}
	
	public void initOrderList(){
		Order order;
		orderList = new ArrayList<Order>();
		
		Product product1 = new Product("iPhone", 600.00);
		OrderItem item1 = new OrderItem(product1, 2);
		
		Product product2 = new Product("Shoes", 45.50);
		OrderItem item2 = new OrderItem(product2, 4);
		
		order = new Order("GSX-56789", "AZ");
		
		order.addItem(item1);
		order.addItem(item2);
		order.addItem(item1);
		order.addItem(item1);
		
		orderList.add(order);
		
		product1 = new Product("Jacket", 79.99);
		item1 = new OrderItem(product1, 6);
		
		product2 = new Product("Goggles", 124.99);
		item2 = new OrderItem(product2, 3);
		
		order = new Order("PYG-11281", "CA");
		
		order.addItem(item1);
		order.addItem(item2);
		
		orderList.add(order);
	}
	
	public List<Order> getOrderList(){
		if(orderList == null){
			initOrderList();
		}
		
		return orderList;
	}
	
	public List<OrderItem> getOrderDetails(String orderCode){
		List<OrderItem> orderedItems = new ArrayList<OrderItem>();
		
		Order order = getOrder(orderCode);
		if(order != null){
			orderedItems = order.getLstOrderItems();
			return orderedItems;
		}
		
		return null;
	}
	
	public Order getOrder(String orderCode) {
		int i;
		Order eachOrder;
		String eachCode;
		
		if(orderList == null){
			initOrderList();
		}
		
		for(i = 0; i < orderList.size(); i++){
			eachOrder = orderList.get(i);
			eachCode = eachOrder.getCode();
			if(eachCode.equals(orderCode)){
				return eachOrder;
			}
		}
		return null;
	}
}
