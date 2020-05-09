package com.cognizant.truyum.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class UserDb {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotNull
	@Column(name="us_id")
	int userId;
	
	
//	@NotNull
	@Column(name="us_name")
	String username;
	
//	@NotNull
	@Column(name="ur_pass")
	String password;
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "ur_us_id"), inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	private Set<Role> roleList;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cart", joinColumns = @JoinColumn(name = "ct_us_id"), inverseJoinColumns = @JoinColumn(name = "ct_pr_id"))
	private List<MenuItem> menuItemList;

	public UserDb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDb(int userId, String username, String password, Set<Role> roleList, List<MenuItem> menuItemList) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.roleList = roleList;
		this.menuItemList = menuItemList;
	}

	

	public UserDb(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	@Override
	public String toString() {
		return "UserDb [userId=" + userId + ", username=" + username + ", password=" + password +"]";
	}

	

	
	
	

}
