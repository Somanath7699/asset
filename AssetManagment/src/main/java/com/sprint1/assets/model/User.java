package com.sprint1.assets.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="User_Table")
public class User implements Serializable{
	@Id
	private int user_Id;
	private String user_name;
	private String role;
	private String user_password;
	
	public User() {
	
	}
	public User(int user_Id, String user_name, String role, String user_password) {
		super();
		this.user_Id = user_Id;
		this.user_name = user_name;
		this.role = role;
		this.user_password = user_password;
	}
	public String getUser_name() 
	{
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", user_name=" + user_name + ", role=" + role + ", user_password="
				+ user_password + "]";
	}
	

}
