package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {

	  MenuItemDaoCollectionImpl menuItemDao;
	  
	  @Autowired
	  MenuItemRepository menuItemRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);

	@Autowired
	public void setMenuItemDao(MenuItemDaoCollectionImpl menuItemDao) {
		this.menuItemDao = menuItemDao;
		LOGGER.info("In Service Service");
	}

	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {

		//return menuItemDao.getMenuItemListCustomer();
		
		return menuItemRepository.getMenuItem();

	}
	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {

		//return menuItemDao.getMenuItemListAdmin();

		return menuItemRepository.findAll();
	}
	@Transactional
	public  MenuItem getMenuItem(int id) {
		
		//return menuItemDao.getMenuItem(id);
		return menuItemRepository.findById(id).get();
		
	}

	public void modifymenuItem(MenuItem menuItem) {
		
		
		menuItemRepository.save(menuItem);
		
		 //menuItemDao.modifyMenuItem(menuItem);
	}

}
