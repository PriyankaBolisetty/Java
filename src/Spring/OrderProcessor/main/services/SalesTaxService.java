package com.npu.orders.services;

import com.npu.orders.domain.Order;

public class SalesTaxService implements TaxService{
	
	public SalesTaxService(){}
	
	public double computeTax(Order order){
		double subTotal, total;
		subTotal = order.getSubTotal();
		System.out.println("Sub Total: " + subTotal);
		System.out.println("Tax: " + 2.5);
		total = subTotal + subTotal * 0.25;
		System.out.println("Total: " + total);
		return total;
	}
}
