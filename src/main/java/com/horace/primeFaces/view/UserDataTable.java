package com.horace.primeFaces.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.horace.primeFaces.domain.User;
import com.horace.primeFaces.service.UserService;

@ManagedBean(name = "userDataTable")
@SessionScoped
public class UserDataTable {
	private User user;
	private List<User> users;
	private List<User> selectedUsers;

	@ManagedProperty("#{userService}")
	private UserService service;

	@PostConstruct
	public void init() {
		users = service.createUsers(10);
	}

	// --------------------------------------------------get and set

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(List<User> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

}
