package com.yash.addressbook.service;

import java.util.List;

import com.yash.addressbook.model.User;

public interface UserService {
	
	public User authenticateUser(String userName, String password) throws Exception;
	public void save(User user);
	public List<User> getAllUser();
	public User getUser(int userId);
	public void delete(int userId);
	public void update(User user);
}
