package com.npu.orders.services;

import com.npu.orders.domain.*;

public class OrderProcessor {
	private AccountingService acctService;
	private InventoryService inventService;
	
	public OrderProcessor(){}
	
	public void setAcctService(AccountingService acctService){
		this.acctService = acctService;
	}
	
	public void setInventService(InventoryService inventService){
		this.inventService = inventService;
	}
	
	public void newOrder(Order order) {
		acctService.recordNewOrder(order);
		acctService.computeTax(order);
		inventService.adjustInventory(order);
	}
	
	public void adjustItemsInIventory(Order order) {
		inventService.adjustInventory(order);
	}
}