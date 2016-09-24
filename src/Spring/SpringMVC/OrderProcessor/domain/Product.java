package com.inventory.orders.domain;

public class Product {
	private int id;
	private String name;
	private double price;
	
	public Product(){}
	
	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}	
	
	@Override
	public boolean equals(Object otherObj){
		if(otherObj == null){
			return false;
		} 
		if(!(otherObj instanceof Product)){
			return false;
		}
		
		Product otherProduct = (Product)otherObj;
		return name.equals(otherProduct.getName()) && price == otherProduct.getPrice();
	}
}
