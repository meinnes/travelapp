package com.travelapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args){
	    try {
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "allmysqldata");
            
            Statement stm=con.createStatement();
            
            System.out.println("Success"); 
        } catch (Exception e) {
            e.printStackTrace(); 
        }
	}
}
