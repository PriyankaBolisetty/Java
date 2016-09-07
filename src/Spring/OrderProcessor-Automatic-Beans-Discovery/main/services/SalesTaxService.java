package com.npu.orders.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.npu.orders.domain.Order;

@Service("taxServiceImpl")
public class SalesTaxService implements TaxService{
	private Float stateTax;
	
	private Map<String, Float> stateTaxRates = new HashMap<String, Float>();;
	
	@Autowired // This is required or else Spring will try using the default constructor 
	public SalesTaxService(@Value("${stateTaxRates.list}") String taxRateListStr) {
	stateTaxRates = convertStringListToMap(taxRateListStr); }
	
	public SalesTaxService(){}
	
	public Map<String, Float> convertStringListToMap(String taxRateListStr){
		Map<String, Float> stateTaxes = new HashMap<String, Float>();
		
		for(String token: taxRateListStr.split(",")){
			String state = token.substring(0, 2);
			Float tax = Float.parseFloat(token.substring(3));
			stateTaxes.put(state, tax);
		}
		return stateTaxes;
	}
	
	public double computeTax(Order order){
		double subTotal, total;
		subTotal = order.getSubTotal();
		System.out.println("Sub Total: " + subTotal);
		
		System.out.println("Tax: " + order.getState());
		
		Set<String> stateKeysSet = stateTaxRates.keySet();
		Iterator<String> stateTaxesIterator = stateKeysSet.iterator();
		while(stateTaxesIterator.hasNext()){
			String state = stateTaxesIterator.next();
			if(state.equals(order.getState())){
				stateTax = stateTaxRates.get(state);
			}
		}
		
		total = subTotal + subTotal * stateTax;
		System.out.println("Total: " + total);
		return total;
	}
}
