package com.inventory.orders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.orders.dao.ProductDAO;
import com.inventory.orders.domain.Product;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDao;
	
	public void addAProduct(Product product){
		productDao.insertAProduct(product);
	}
	
	public void updateAProductPrice(String name, double price){
		productDao.updatePriceForAProduct(name, price);
	}
}
