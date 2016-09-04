package com.npu.orders.services;

import com.npu.orders.domain.*;

public class OrderProcessor {
	private AccountingService acctService;
	private InventoryService inventService;
	
	public OrderProcessor(){}
	
	public OrderProcessor(AccountingService acctService, InventoryService inventService){
		this.acctService = acctService;
		this.inventService = inventService;
	}
	
	public void newOrder(Order order) {
		acctService.recordNewOrder(order);
		acctService.computeTax(order);
	}
	
	public void adjustItemsInIventory(Order order) {
		inventService.adjustInventory(order);
	}
}