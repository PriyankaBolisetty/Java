package com.inventory.orders.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inventory.orders.domain.Product;
import com.inventory.orders.services.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//present the product data form
	@RequestMapping(value="/addproduct", method=RequestMethod.GET)
	public ModelAndView addProductForm(){
		ModelAndView modelView = new ModelAndView("addAProductForm");
		
		modelView.addObject("product", new Product());
		return modelView;
	}
	
	//process the product to be added to the database
	@RequestMapping(value="/saveNewProduct", method=RequestMethod.POST)
	public ModelAndView processAddProduct(@ModelAttribute("product") @Valid Product product, BindingResult result){
		ModelAndView modelView;
		
		if(result.hasErrors()){
			//re-present the form with error messages
			modelView = new ModelAndView("addAProductForm");
			return modelView;
		}
		
		productService.addAProduct(product);
		modelView = new ModelAndView("newProductAddedSuccess");
		modelView.addObject(product);
		return modelView;
	}
	
	@RequestMapping(value="/updateProductPriceForm", method=RequestMethod.GET)
	public ModelAndView updatePriceForAProduct(){
		ModelAndView modelView = new ModelAndView("updateProductPriceForm");
		modelView.addObject("product", new Product());
		
		return modelView;
	}
	
	@RequestMapping(value="/saveUpdatedProductPrice", method=RequestMethod.POST)
	public ModelAndView updatePriceForAProduct(@ModelAttribute("product") @Valid Product product, BindingResult result){
		ModelAndView modelView;
		
		if(result.hasErrors()){
			//re-present the form with error messages
			modelView = new ModelAndView("updateProductPriceForm");
			return modelView;
		}
		
		productService.updateAProductPrice(product.getName(), product.getPrice());
		modelView = new ModelAndView("productPriceUpdatedSuccess");
		modelView.addObject(product);
		return modelView;
	}
}
