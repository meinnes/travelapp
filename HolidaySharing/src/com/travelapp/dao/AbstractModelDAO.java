package com.travelapp.dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;


public class AbstractModelDAO {
	
	protected Connection getDBConnection() throws ClassNotFoundException{
		loadDriver();
		Connection con = (Connection) ConnectionManager.getConnection("mysql", "localhost", 3306, "TRAVELAPP", "root", "allmysqldata");
		return con;
	}

	private static void loadDriver(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
