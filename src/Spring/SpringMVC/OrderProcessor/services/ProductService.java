package com.inventory.orders.services;

import com.inventory.orders.domain.Product;

public interface ProductService {
	void addAProduct(Product product);
	void updateAProductPrice(String name, double price);
}
