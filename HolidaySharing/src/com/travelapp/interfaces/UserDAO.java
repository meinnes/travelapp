package com.travelapp.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.travelapp.vo.User;

public interface UserDAO {
	
	public ArrayList<User> getAllUsers();
	public int addUser(User user) throws SQLException, ClassNotFoundException;
	public User getUser(String userName) throws SQLException, ClassNotFoundException;
	public void deleteUser(User user);
	public void updateUser(User user);
	public boolean checkExistence(String email) throws ClassNotFoundException, SQLException;
	public boolean checkDuplicates(String userName) throws SQLException, ClassNotFoundException;
	public boolean login(String userName, String password) throws ClassNotFoundException, SQLException;
}
