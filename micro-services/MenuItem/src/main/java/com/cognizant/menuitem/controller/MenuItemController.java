package com.cognizant.menuitem.controller;
//
//import java..MenuItem;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuitem.model.MenuItem;
import com.cognizant.menuitem.security.AppUserDetailsService;
import com.cognizant.menuitem.service.MenuItemService;



@CrossOrigin("http://localhost:4200")
@RequestMapping("/menu-items")
@RestController
public class MenuItemController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

//	@Autowired
//	private InMemoryUserDetailsManager inMemoryUserDetailsManager;

//	@Autowired
//	UserController userController;

	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Autowired
	private MenuItemService menuItemService;

	
//	public void setMenuItemService(MenuItemService menuItemService) {
//		this.menuItemService = menuItemService;
//		LOGGER.info("In Service COntroller");
//	}

	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable int id) {

		return menuItemService.getMenuItem(id);

	}

	@PutMapping
	public void modifyMenuItem(@RequestBody MenuItem menuItem) {

		String s = menuItem.getName();
		LOGGER.info(s);
		menuItemService.modifymenuItem(menuItem);

	}

	@GetMapping("/all")
	public List<MenuItem> getAllMenuItems() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();

		
		LOGGER.info("one" + user);

		if (user.equals("anonymousUser")) {

			return menuItemService.getMenuItemListCustomer();
		} else {
			UserDetails userDetails = appUserDetailsService.loadUserByUsername(user);
			String role = userDetails.getAuthorities().toArray()[0].toString();
			LOGGER.info("one" + role);
			if (role.equals("ADMIN")) {
				return menuItemService.getMenuItemListAdmin();

			} else {

				return menuItemService.getMenuItemListCustomer();
			}
		}

	}

}
