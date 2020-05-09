package com.cognizant.authentication.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="ro_id")
	int roleId;
	
	
	@NotNull
	@Column(name="ro_name")
	String roleName;

	
	  @ManyToMany(mappedBy = "roleList",fetch = FetchType.EAGER)
	    private Set<UserDb> userList;

	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Role(@NotNull int roleId, @NotNull String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}


	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	
	
}
