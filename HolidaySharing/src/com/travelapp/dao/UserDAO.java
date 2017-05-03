package com.travelapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.travelapp.main.User;

public interface UserDAO {
	
	public ArrayList<User> getAllUsers()throws SQLException;
	public int addUser(User user)throws SQLException;
	public User getUserById(int id)throws SQLException;
	public void deleteUser(User user)throws SQLException;
	public void updateUser(User user)throws SQLException;

}
