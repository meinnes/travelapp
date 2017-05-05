package com.travelapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public static Connection getConnection(String type, String host, int port, String dbName,
			String user, String pass) throws ClassNotFoundException{

		Connection con=null;

		try{
			String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":")
					.append(port).append("/").append(dbName).append("?user=").append(user).append("&password=")
					.append(pass).toString();
			System.out.println("URL:" + url);
			con = DriverManager.getConnection(url);
			
		}catch(SQLException e){
			System.err.println("Cannot connect to database: "+e.getMessage());
		}
		return con;
	}


}
