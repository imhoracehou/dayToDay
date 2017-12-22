package com.horace.primeFaces.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.horace.primeFaces.domain.User;

@ManagedBean(name = "userService")
@ApplicationScoped
public class UserService {

	public List<User> createUsers(int size) {
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < size; i++) {
			User user = new User();
			user.setId("ID" + i);
			user.setName("Name" + i + "s");
			list.add(user);
		}
		return list;
	}

}
