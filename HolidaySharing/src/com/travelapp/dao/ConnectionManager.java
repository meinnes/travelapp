package com.travelapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	public static Connection getConnection(String type, String host, int port, String dbName, String user, String pass){
		
		Connection connection = null;
		DriverManager.setLoginTimeout(60);
		
		try{
			String url= new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":").append(port).append("/").append(dbName).append("?user=").append(user).append("&password=").append(pass).toString();
			System.out.println("URL:"+ url);
			connection = DriverManager.getConnection(url);
		}catch(SQLException e){
			System.err.println("Cannot connect to database: "+e.getMessage());
		}
		return connection;
	}

}
