package com.cognizant.menuitem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.menuitem.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

	@Query(value="select * from truyum_v2.menu_item where me_active = 1 && me_date_of_launch <=\"2019-02-19 \"",nativeQuery = true)
	List<MenuItem> getMenuItem();
	
	
}
