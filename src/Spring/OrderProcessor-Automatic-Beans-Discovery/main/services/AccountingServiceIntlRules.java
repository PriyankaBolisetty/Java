package com.npu.orders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.npu.orders.domain.Order;

@Service("acctServiceIntlRules")
public class AccountingServiceIntlRules implements AccountingService {
	
	@Autowired
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
