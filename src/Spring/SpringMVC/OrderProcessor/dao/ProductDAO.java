package com.inventory.orders.dao;

import java.util.List;

import com.inventory.orders.domain.Product;

public interface ProductDAO {
	List<Product> getAllAvailableProductsInStore();
	int getProductsCount();
	void insertAProduct(Product product);
	void updatePriceForAProduct(String name, double price);
}
