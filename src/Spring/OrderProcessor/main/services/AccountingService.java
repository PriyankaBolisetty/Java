package com.npu.orders.services;
import com.npu.orders.domain.*;

public interface AccountingService {
	public void recordNewOrder(Order order);
	double computeTax(Order order);
}