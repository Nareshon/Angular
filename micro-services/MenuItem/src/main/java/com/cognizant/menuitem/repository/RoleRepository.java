package com.cognizant.menuitem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.menuitem.model.Role;





public interface RoleRepository  extends JpaRepository<Role, Integer> {

	
	Role findById(int id);
	
}
