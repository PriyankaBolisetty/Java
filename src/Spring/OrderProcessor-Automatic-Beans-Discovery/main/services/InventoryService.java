package com.npu.orders.services;
import org.springframework.stereotype.Service;

import com.npu.orders.domain.*;

public interface InventoryService {
	public void adjustInventory(Order order);
	public void printCurrentInventory();
}
