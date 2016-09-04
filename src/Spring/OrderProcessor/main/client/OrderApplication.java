package com.npu.orders.client;

import com.npu.orders.domain.*;
import com.npu.orders.services.AccountingService;
import com.npu.orders.services.InventoryService;
import com.npu.orders.services.OrderProcessor;
import com.npu.orders.services.TaxService;

import java.util.ArrayList;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderApplication {
	public static void main(String args[]) {
		ApplicationContext container = new ClassPathXmlApplicationContext("app-context.xml");
		Order order;
		OrderProcessor orderProc = (OrderProcessor)container.getBean("orderProc");
		
		InventoryService inventService = (InventoryService)container.getBean("inventoryServiceImpl");
		//AccountingService acctService = (AccountingService) container.getBean("acctServiceIntlRules");
		
		inventService.printCurrentInventory();
		
		Product product1 = new Product("iPhone", 600.00);
		OrderItem item1 = new OrderItem(product1, 2);
		
		Product product2 = new Product("Shoes", 45.50);
		OrderItem item2 = new OrderItem(product2, 4);
		
		order = new Order("GSX-56789");
		
		order.addItem(item1);
		order.addItem(item2);
		order.addItem(item1);
		order.addItem(item1);
		
		order.removeProduct(product1);
		
		ArrayList<OrderItem> orderedItems = order.getLstOrderItems();
		for(int i = 0; i < orderedItems.size(); i++){
			System.out.println(orderedItems.get(i).getProduct().getName() + ": " + orderedItems.get(i).getQuantity());
		}
		
		orderProc.newOrder(order);
		
		//acctService.recordNewOrder(order);
		//acctService.ad;
		
		//orderProc.newOrder(order);
	}
}
