package com.npu.orders.services;
import com.npu.orders.domain.*;

public interface BillingService {
	public void billCustomer(Customer cus, Order order);
}
