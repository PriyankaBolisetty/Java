package com.jobs.gethired.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jobs.gethired.domain.Order;
import com.jobs.gethired.domain.OrderItem;

@Component("orderService")
public interface OrderService {
	List<OrderItem> getOrderDetails(String orderCode);
	//void addItemToOrder(OrderItem item, Order order);
}
