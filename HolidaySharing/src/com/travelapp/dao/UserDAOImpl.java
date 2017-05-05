package com.travelapp.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.travelapp.interfaces.UserDAO;
import com.travelapp.vo.User;

public class UserDAOImpl extends AbstractModelDAO implements UserDAO {

	private PreparedStatement ps;
	private ResultSet rs = null;
	private ArrayList<User> allUsers;
	private User user;

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(User user) throws SQLException, ClassNotFoundException {
		
		ps = getDBConnection().prepareStatement("insert into users (firstName, lastName, email, userName, password) values(?,?,?,?,?)");
		ps.setString(1, user.getFirstName());
		ps.setString(2, user.getLastName());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getUserName());
		ps.setString(5, user.getPassword());
		int row = ps.executeUpdate();
		
		System.out.println(row+" new user added");
		return row;
	}

	@Override
	public User getUser(String userName) throws SQLException, ClassNotFoundException {

		User user = new User();
		ps = getDBConnection().prepareStatement("select * from users where userName = ?");
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
			
		if(rs.next()){
		  user.setFirstName(rs.getString(2));
		  user.setLastName(rs.getString(3));
		  user.setEmail(rs.getString(4));
		  user.setUserName(rs.getString(5));
		  user.setPassword(rs.getString(6));
		}
	
	 	return user;

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkExistence(String email) throws ClassNotFoundException, SQLException {
		ps = getDBConnection().prepareStatement("select * from users where email = ?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkDuplicates(String userName) throws SQLException, ClassNotFoundException {
		ps = getDBConnection().prepareStatement("select * from users where userName = ?");
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			return true;
		}
		return false;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public boolean login(String userName, String password) throws ClassNotFoundException, SQLException{
		ps = getDBConnection().prepareStatement("select userName, password from users where userName=? and password=?");
		ps.setString(1, userName);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			return true;
		} 
		return false;
		
	}


}
