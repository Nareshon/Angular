package com.cognizant.menuitem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

import com.sun.istack.NotNull;


@Entity
@Table(name = "menu_item")
public class MenuItem {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="me_id")
	private int id;
	
	@NotNull
	@Column(name="me_name")
	private String name;
	@NotNull
	@Column(name="me_price")
	private float price;
	@NotNull
	@Column(name="me_active")
	private boolean active;
	@NotNull
	@Column(name="me_date_of_launch")
	private Date dateOfLaunch;
	@NotNull
	@Column(name="me_category")
	private String category;
	@NotNull
	@Column(name="me_free_delivery")
	private boolean freeDelivery;
	@NotNull
	@Column(name="me_url")
	private String url;
	
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isFreeDelivery() {
		return freeDelivery;
	}
	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public MenuItem(int id, String name, float price, boolean active, Date dateOfLaunch, String category,
			boolean freeDelivery, String url) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
		this.url = url;
	}
	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + ", url=" + url + "]";
	}
	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
