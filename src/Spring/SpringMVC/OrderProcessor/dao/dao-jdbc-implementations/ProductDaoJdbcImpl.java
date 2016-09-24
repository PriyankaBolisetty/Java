package com.inventory.orders.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.inventory.orders.dao.ProductDAO;
import com.inventory.orders.domain.Product;

@Repository("productDaoJdbc")
public class ProductDaoJdbcImpl implements ProductDAO{

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private ProductRowMapper productRowMapper;
	
	@PostConstruct
	public void setup(){
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		jdbcInsert = new SimpleJdbcInsert(dataSource).
							withTableName("Product").usingGeneratedKeyColumns("id");
		productRowMapper = new ProductRowMapper();
	}
	
	public int getProductsCount(){
		String queryString = "SELECT COUNT(*) FROM ordersdb.Product"; 
		
		return jdbcTemplate.queryForObject(queryString, Integer.class);
	}
	
	public List<Product> getAllAvailableProductsInStore(){
		String queryString = "SELECT * FROM ordersdb.Product";
		//List<Product> productsList = jdbcTemplate.query(queryString, productRowMapper);
		
		List<Product> productsList = dbTemplate.query(queryString, productRowMapper);
		return null;
	}
	
	public void insertAProduct(Product product){
		 //SqlParameterSource params = new BeanPropertySqlParameterSource(product);
		 
		Map<String, Object> productParams = getProductParams(product);
		
		 int newId = jdbcInsert.executeAndReturnKey(productParams).intValue();
		 product.setId(newId);
	}

	public Map<String, Object> getProductParams(Product product) {
		Map<String, Object> productParams = new HashMap<String, Object>();
		
		productParams.put("name", product.getName());
		productParams.put("price", product.getPrice());
		
		return productParams;
	}
	
	public void updatePriceForAProduct(String name, double price){
		String queryString = "UPDATE ordersdb.Product SET price=? WHERE name=?";
		
		jdbcTemplate.update(queryString, price, name);
	}
}
