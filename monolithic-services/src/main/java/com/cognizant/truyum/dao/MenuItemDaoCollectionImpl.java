package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoCollectionImpl {
	
	private static ArrayList<MenuItem> menuItemList;
	private  MenuItem searchItem=null;
	MenuItemDaoCollectionImpl(){
		if(menuItemList==null) {
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		menuItemList = (ArrayList<MenuItem>) context.getBean("menuItemList");
		}
		}
	
	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);
	
	
	
	
	public static ArrayList<MenuItem> getAllMenuItems(){
		LOGGER.info("Getting menuitem List from MenuItemDao");
	
		
		return menuItemList ;
	}



	
	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("Getting ");
		
		return menuItemList ;
	}




	public List<MenuItem> getMenuItemListCustomer() {
		
//		
//		LOGGER.info("Getting menuitem List from MenuItemDao");
//		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
//		menuItemList = (ArrayList<MenuItem>) context.getBean("menuItemList");
		 ArrayList menuItemListCustomer=new ArrayList();
		for(MenuItem menuItem :menuItemList) {
			
			if(menuItem.getDateOfLaunch().before(new Date() )&& menuItem.isActive()) {
				menuItemListCustomer.add(menuItem);
			}
			
			
		}
		
		
		return menuItemListCustomer ;
		
		
	}




	public void modifyMenuItem(MenuItem menuItem) {
		
	
		searchItem=getMenuItem((int)menuItem.getId());
		int i=menuItemList.indexOf(searchItem);
		menuItemList.set(i, menuItem);
		LOGGER.info(menuItem.getName());
		LOGGER.info(searchItem.getName());
		LOGGER.debug("y"+menuItemList);
		
		
		
		
		
	}



	
	public MenuItem getMenuItem(int menuItemId) {
		
		getMenuItemListAdmin();
		
		for(MenuItem menuItem:menuItemList) {
			if(menuItemId==(menuItem.getId())) {
				return menuItem;
			}
			
		}
		return null;
		
		
		
	}
	
	
}
