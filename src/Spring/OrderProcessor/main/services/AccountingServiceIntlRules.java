package com.npu.orders.services;

import com.npu.orders.domain.Order;

public class AccountingServiceIntlRules implements AccountingService {
	
	private TaxService salesTax;
	
	public AccountingServiceIntlRules(){}
	
	/*public AccountingServiceIntlRules(TaxService salesTax){
		this.salesTax = salesTax;
	}*/
	
	public void setSalesTax(TaxService salesTax){
		this.salesTax = salesTax;
	}
	
	public void recordNewOrder(Order order) {
		System.out.println("Applying International Accounting Rules");
		return;
	}
	
	public double computeTax(Order order){
		return salesTax.computeTax(order);
	}
}
