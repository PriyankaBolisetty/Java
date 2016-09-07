package com.npu.orders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npu.orders.domain.*;

@Service("orderProc")
public class OrderProcessor {
	private AccountingService acctService;
	private InventoryService inventService;
	
	public OrderProcessor(){}
	
	@Autowired
	public void setAcctService(AccountingService acctService){
		this.acctService = acctService;
	}
	
	@Autowired
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