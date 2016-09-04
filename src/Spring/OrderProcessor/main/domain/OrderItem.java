package com.npu.orders.domain;

public class OrderItem {
	private Product product;
	private int quantity;
	
	public OrderItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object otherObj){
		if(otherObj == null){
			return false;
		} 
		if(!(otherObj instanceof OrderItem)){
			return false;
		}
		
		OrderItem otherItem = (OrderItem)otherObj;
		return product.equals(otherItem.getProduct());
	}
}
