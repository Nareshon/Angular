package com.cognizant.menuitem.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuitem.model.CartDTO;
import com.cognizant.menuitem.service.CartService;




@CrossOrigin("http://localhost:4200")
@RequestMapping("/cart") 
@RestController
public class CartController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
	
	
	CartService cartService;
	@Autowired
	public void setEmployeeService(CartService cartService) {
		this.cartService = cartService;
	}

	@DeleteMapping("{userName}/{id}")
	public  void deleteCarts(@PathVariable String userName,@PathVariable int id) {
		// TODO Auto-generated method stub
		 cartService.deleteCarts(userName,id);
		 LOGGER.debug("remove1"+id);
	}
	
	
	
	
	
	
	@RequestMapping("/show-cart/{name}")
	public  CartDTO showCarts(@PathVariable String name) {
		// TODO Auto-generated method stub
		return cartService.showCarts(name);
	}
	
	
	@PostMapping("/{userName}/{menuId}")
	public void addCartItem(@PathVariable String userName,@PathVariable long menuId) {
		
		cartService.addCartItem(userName, menuId);
		
		LOGGER.debug("dsaa"+userName);
		
		
	}
	
	
}
