package com.cognizant.truyum.dao;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.CartDTO;

public interface CartDao {

	

		public void addCartItem(String userName, long menuItemId);

		public CartDTO getAllCartItems(String userName) throws CartEmptyException;

		public void removeCartItem(String userName, long menuItemId);
	}

	
	
	

