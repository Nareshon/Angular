package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.CartDTO;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@Component
public class CartDaoCollectionImpl implements CartDao {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartDaoCollectionImpl.class);
	public static HashMap<String, CartDTO> userCarts;

	public  CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<String, CartDTO>();
		}
	}

	

	@Override
	public CartDTO getAllCartItems(String userName) throws CartEmptyException {
		CartDTO cart = userCarts.get(userName);
		double total = 0.0;

		List<MenuItem> menuItemList = null;
		if (cart != null) {
			menuItemList = cart.getMenuItemList();
			if (menuItemList == null || menuItemList.isEmpty()) {
				//throw new CartEmptyException();
				cart.setTotal(0.0);
			} else {
				 total = 0.0;
				for (MenuItem menuItem : menuItemList) {
					total += menuItem.getPrice();
				}
				cart.setTotal(total);
			}
		}
		return cart;
	}

	@Override
	public void removeCartItem(String userName, long menuItemId) {
		CartDTO cart = userCarts.get(userName);
		List<MenuItem> menuItemList = null;
		if (cart != null) {
			menuItemList = cart.getMenuItemList();
			int indexOfMatchingItem = 0;
			for (MenuItem menuItem : menuItemList) {
				if (menuItem.getId() == menuItemId) {
					indexOfMatchingItem = menuItemList.indexOf(menuItem);
					break;
				}

			}
			menuItemList.remove(indexOfMatchingItem);
		}
		 LOGGER.debug("remove1"+userName+"remove2"+menuItemId);

	}
	
	@Override
	public void addCartItem(String userName, long menuItemId) {
		// TODO Auto-generated method stub
		
		LOGGER.info("dasdasad"+userName);
		
		MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem((int)menuItemId);

		CartDTO cart = userCarts.get(userName);
		if (cart != null) {
			List<MenuItem> menuItemList = cart.getMenuItemList();
			menuItemList.add(menuItem);
		} else {
			List<MenuItem> newMenuItemList = new ArrayList<MenuItem>();
			CartDTO newCart = new CartDTO(newMenuItemList, 0.0);
			newCart.getMenuItemList().add(menuItem);
			userCarts.put(userName, newCart);

		}
		LOGGER.info("12323"+userCarts);
	}




	
	
	
}
