package com.orm.orders.dao;

import java.util.List;

import com.orm.orders.domain.Product;

public interface ProductDAO {
	/*List<Product> getAllAvailableProductsInStore();
	int getProductsCount();
	void updatePriceForAProduct(String name, double price);
	List<String> getAllProductNames();*/
	
	void insertAProduct(Product product);
}
