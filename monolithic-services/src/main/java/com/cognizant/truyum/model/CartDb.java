package com.cognizant.truyum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartDb {

	
	@Override
	public String toString() {
		return "CartDb [id=" + id + ", userDb=" + userDb + ", menuItem=" + menuItem + "]";
	}


	public CartDb() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CartDb(int id, UserDb userDb, MenuItem menuItem) {
		super();
		this.id = id;
		this.userDb = userDb;
		this.menuItem = menuItem;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ct_id")
	int id;
	
	@ManyToOne
	@JoinColumn(name = "ct_us_id")
	UserDb userDb;
	
	
	@ManyToOne
	@JoinColumn(name = "ct_pr_id")
	MenuItem menuItem;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public UserDb getUserDb() {
		return userDb;
	}


	public void setUserDb(UserDb userDb) {
		this.userDb = userDb;
	}
	
	
}
