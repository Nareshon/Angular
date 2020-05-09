package com.cognizant.truyum.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.model.CartDTO;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.UserDb;
import com.cognizant.truyum.repository.MenuItemRepository;
import com.cognizant.truyum.repository.UserRepository;

@Service
public class CartService {

	CartDaoCollectionImpl cartDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	MenuItemRepository menuItemRepository;
	
	
	@Autowired
	public void CartDao(CartDaoCollectionImpl cartDao) {
		this.cartDao =  cartDao;
		
	}
	
	@Transactional
	public void addCartItem(String userName,long menuItemId) {

		
//		
//		cartDao.addCartItem(userName, menuItemId);
//		LOGGER.debug("d"+userName);
		
		UserDb user =	userRepository.findByUsername(userName);
		MenuItem menuItem = menuItemRepository.findById((int)menuItemId).get();
		
		if(menuItem!=null) {
			
			List<MenuItem> menuItemList=user.getMenuItemList();
			menuItemList.add(menuItem);
			
			user.setMenuItemList(menuItemList);
		
			userRepository.save(user);
		}
		
		
	}

	@Transactional
	public  CartDTO showCarts(String name) {
		
		
//		// TODO Auto-generated method stub
//		try {
//			return cartDao.getAllCartItems(name);
//		} catch (CartEmptyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//		
		
		UserDb user =	userRepository.findByUsername(name);
		
		System.out.println(user);
		
		
		CartDTO cart = new CartDTO();
		try {
			List<MenuItem> menuItemList =  user.getMenuItemList();
			
			System.out.println(menuItemList);
			
			cart = new CartDTO();
			cart.setMenuItemList(menuItemList);
			
			int id=user.getUserId();
			double total = userRepository.getCartTotalPrice(id);
			
					
			cart.setTotal(total);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cart;
		
		
	}
	@Transactional
	public void deleteCarts(String userName,int id) {
		// TODO Auto-generated method stub
//		 cartDao.removeCartItem(userName, id);
//		 LOGGER.debug("remove1"+id);
		
		
		UserDb user =	userRepository.findByUsername(userName);
		
	
		
		MenuItem menuItem=menuItemRepository.findById(id).get();
		
		List<MenuItem> menuItemList =  user.getMenuItemList();
		
		
		menuItemList.remove(menuItem);
		user.setMenuItemList(menuItemList);
		userRepository.save(user);
		
		
		
		
	}

	
	
	
}
