package com.cognizant.menuitem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.menuitem.model.UserDb;



public interface UserRepository extends JpaRepository<UserDb, Integer>{

	UserDb findByUsername(String username);
	
	@Query(value="SELECT SUM(m.me_price) AS cart_total FROM menu_item AS m INNER JOIN cart AS c ON m.me_id = c.ct_pr_id WHERE c.ct_us_id = ?1",nativeQuery = true)
    Double getCartTotalPrice(int userId);

	
	
}
