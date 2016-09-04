package com.npu.orders.domain;

import java.util.ArrayList;

public class Order {
	private String code;
	private Customer customer;
	private ArrayList<OrderItem> lstOrderItems;
	private double subTotal, tax, total;
	
	public Order(String newOrderCode) {
		code = newOrderCode;
	}
	
	public ArrayList<OrderItem> getLstOrderItems(){
		return lstOrderItems;
	}
	
	public double getSubTotal(){
		return subTotal;
	}
	
	public void setSubTotal(double subTotal){
		this.subTotal = subTotal;
	}
	
	public double getTotal(){
		return total;
	}
	
	public void setTotal(double total){
		this.total = total;
	}
	
	public void addItem(OrderItem item){
		OrderItem eachItem;
		int originalQty, newQty;
		
		if(lstOrderItems == null){
			lstOrderItems = new ArrayList<OrderItem>();
			lstOrderItems.add(item);
			subTotal += item.getProduct().getPrice() * item.getQuantity();
			System.out.println("Each item's subtotal: " + subTotal);
		}
		
		else if(lstOrderItems != null){
			for(int i = 0; i < lstOrderItems.size(); i++){
				eachItem = lstOrderItems.get(i);
				if(eachItem.equals(item)){
					originalQty = eachItem.getQuantity();
					newQty = item.getQuantity();
					//Update the quantity
					eachItem.setQuantity(originalQty + newQty);
					subTotal += eachItem.getProduct().getPrice() * item.getQuantity();
					System.out.println("Each item's subtotal: " + subTotal);
					return;
				} else{
					//add the item
					lstOrderItems.add(item);
					subTotal += item.getProduct().getPrice() * item.getQuantity();
					System.out.println("Each item's subtotal: " + subTotal);
					return;
				}	 
			}
		}
	}
	
	public void removeProduct(Product product){
		OrderItem eachItem;
		Product eachProduct;
		
		if(lstOrderItems != null){
			for(int i = 0; i < lstOrderItems.size(); i++){
				eachItem = lstOrderItems.get(i);
				eachProduct = eachItem.getProduct();
				if(eachProduct.getName().equals(product.getName())){
					lstOrderItems.remove(eachItem);
					subTotal -= product.getPrice() * eachItem.getQuantity();
					System.out.println("Removed item's subtotal: " + subTotal);
					return;
				}
			}
		}
	}
}
