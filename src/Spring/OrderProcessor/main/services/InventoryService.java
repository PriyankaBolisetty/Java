package com.npu.orders.services;
import com.npu.orders.domain.*;

public interface InventoryService {
	public void adjustInventory(Order order);
	public void printCurrentInventory();
}
