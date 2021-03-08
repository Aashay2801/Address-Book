package com.yash.addressbook.dao;

import java.sql.SQLException;
import java.util.List;

import com.yash.addressbook.model.User;

public interface UserDao {
	
	public User authenticateUser(String userName, String password) throws Exception;
	public void saveUser(User user);
	public List<User> getAllUser();
	public User getUser(int userId);
	public void deleteUser(int userId);
	public void updateUser(User user);
}
