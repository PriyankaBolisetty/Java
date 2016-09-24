package com.inventory.orders.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inventory.orders.domain.Product;

public class ProductRowMapper implements RowMapper<Product>{
	
	public Product mapRow(ResultSet rsltSet, int row) throws SQLException {
		
		Product product;
		String name = rsltSet.getString("name");
		double price = rsltSet.getDouble("price");
		
		product = new Product(name, price);
		product.setId(rsltSet.getInt("id"));
		
		return product;
	}
}
