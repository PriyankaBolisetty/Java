package com.npu.orders.services;

import com.npu.orders.domain.Order;

public class AccountingServiceIntlRules implements AccountingService {
	
	private TaxService salesTax;
	
	public AccountingServiceIntlRules(){}
	
	//Have to add this set method, when we add this as a property to other beans
	public void setSalesTax(TaxService salesTax){
		this.salesTax = salesTax;
	}
	
	public void recordNewOrder(Order order) {
		return;
	}
	
	public double computeTax(Order order){
		return salesTax.computeTax(order);
	}
}
