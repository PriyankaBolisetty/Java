package com.jobs.gethired.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobs.gethired.domain.OrderItem;
import com.jobs.gethired.services.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/getorderdetails", method = RequestMethod.GET)
	public String getOrderDetailsForm(){
		return "enterOrderNoForm";
	}
	
	@RequestMapping(value="/listItems", method = RequestMethod.GET)
	public ModelAndView getItemsList(String orderCode){
		List<OrderItem> itemList;
		ModelAndView modelView;
		
		itemList = orderService.getOrderDetails(orderCode);
		modelView = new ModelAndView("viewItemList");
		modelView.addObject("orderCode", orderCode);
		modelView.addObject("itemList", itemList);
		
		return modelView;
	}
}
