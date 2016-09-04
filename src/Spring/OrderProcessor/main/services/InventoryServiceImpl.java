package com.npu.orders.services;

import java.util.ArrayList;

import com.npu.orders.domain.Order;
import com.npu.orders.domain.OrderItem;
import com.npu.orders.domain.Product;

public class InventoryServiceImpl implements InventoryService{
	Product product1, product2, product3, product4, product5;
	OrderItem item1, item2, item3, item4, item5; 
	ArrayList<OrderItem> lstInventoryItems = new ArrayList<OrderItem>();
	
	public InventoryServiceImpl(){
		addProductsToInventory();
	}
	
	public void addProductsToInventory(){
		product1 = new Product("iPhone", 600.00);
		product2 = new Product("Jacket", 70.99);
		product3 = new Product("Shoes", 34.50);
		product4 = new Product("Laptop", 1300.99);
		product5 = new Product("Car", 11000.00);
		
		item1 = new OrderItem(product1, 3);
		item2 = new OrderItem(product2, 6);
		item3 = new OrderItem(product3, 4);
		item4 = new OrderItem(product4, 10);
		item5 = new OrderItem(product5, 3);
		
		lstInventoryItems.add(item1);
		lstInventoryItems.add(item2);
		lstInventoryItems.add(item3);
		lstInventoryItems.add(item4);
		lstInventoryItems.add(item5);
	}
	
	public void adjustInventory(Order order) {
		//System.out.println("Applying Inventory Service Rules");
		return;
	}
	
	public void printCurrentInventory() {
		System.out.println("Current Inventory details:");
		System.out.println("===============================");
		for(int i = 0; i < lstInventoryItems.size(); i++){
			System.out.println(lstInventoryItems.get(i).getProduct().getName() + ": " +
					+ lstInventoryItems.get(i).getQuantity());
		}
		System.out.println("===============================");
	}
}
