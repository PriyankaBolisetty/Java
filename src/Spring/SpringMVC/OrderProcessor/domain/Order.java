package com.inventory.orders.domain;

import java.util.ArrayList;

public class Order {
	private String code, state;
	private int id;
	private Customer customer;
	private ArrayList<OrderItem> lstOrderItems;
	private double subTotal = 0.0, tax, total;
	
	public Order(String newOrderCode, String state) {
		code = newOrderCode;
		this.state = state;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState(){
		return state;
	}
	
	public void setState(String state){
		this.state = state;
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
			System.out.println(item.getProduct().getName() + " subtotal: " + subTotal);
		}
		
		else if(lstOrderItems != null){
			for(int i = 0; i < lstOrderItems.size(); i++){
				eachItem = lstOrderItems.get(i);
				if(eachItem.equals(item)){
					originalQty = eachItem.getQuantity();
					newQty = item.getQuantity();
					//Update the quantity
					eachItem.setQuantity(originalQty + newQty);
					subTotal += eachItem.getProduct().getPrice() * newQty;
					System.out.println(eachItem.getProduct().getName() + " subtotal: " + subTotal);
					return;
				} else{
					//add the item
					lstOrderItems.add(item);
					subTotal += item.getProduct().getPrice() * item.getQuantity();
					System.out.println(item.getProduct().getName() + " subtotal: " + subTotal);
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
					System.out.println("Removed item " + product.getName() + " subtotal: " + subTotal);
					return;
				}
			}
		}
	}
}
