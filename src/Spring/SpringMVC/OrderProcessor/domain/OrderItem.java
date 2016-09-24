package com.inventory.orders.domain;

public class OrderItem {
	private Order order;
	private Product product;
	private int quantity;
	
	private int order_id;
	private int product_id;
	
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	/*public OrderItem(Order order, Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		this.order_id = order.getId();
		this.product_id = product.getId();
	}*/

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
	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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
