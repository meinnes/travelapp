package com.travelapp.dao;

import com.mysql.jdbc.Connection;

public class AbstractModelDAO {
	
	protected Connection getDBConnection(){
		loadDriver();
		Connection conn = (Connection) ConnectionManager.getConnection("mysql", "localhost", 3306, "travelapp", "root", "allmysqldata");
		return conn;
	}
	
	private static void loadDriver(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
