package com.npu.orders.services;

import com.npu.orders.domain.Order;

public interface TaxService {
	double computeTax(Order order);
}
