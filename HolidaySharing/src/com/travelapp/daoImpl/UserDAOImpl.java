package com.travelapp.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.travelapp.dao.AbstractModelDAO;
import com.travelapp.dao.ConnectionManager;
import com.travelapp.dao.UserDAO;
import com.travelapp.main.User;

public class UserDAOImpl extends AbstractModelDAO implements UserDAO {

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	ArrayList<User> allUsers;

	@Override
	public ArrayList<User> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(User user) throws SQLException {
		ps = getDBConnection().prepareStatement("insert into users values(?,?,?,?,?,?)");
		ps.setInt(1, user.getId());
		ps.setString(2, user.getFirstName());
		ps.setString(3, user.getLastName());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getUserName());
		ps.setString(6, user.getPassword());
		int row = ps.executeUpdate();
		return row;
	}

	@Override
	public User getUserById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
