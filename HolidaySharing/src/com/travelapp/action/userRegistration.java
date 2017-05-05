package com.travelapp.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travelapp.dao.UserDAOImpl;
import com.travelapp.interfaces.UserDAO;
import com.travelapp.vo.User;

public class userRegistration extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		boolean emailExists = false;
		boolean userExists = false;
		User user = new User();
		UserDAO userDAO = new UserDAOImpl();
		
		user.setFirstName(req.getParameter("firstName"));
		user.setLastName(req.getParameter("lastName"));
		user.setEmail(req.getParameter("email"));
		user.setUserName(req.getParameter("userName"));
		user.setPassword(req.getParameter("password"));
		
		try {
			emailExists = userDAO.checkExistence(user.getEmail());
			userExists = userDAO.checkDuplicates(user.getUserName());
			if(emailExists){
				System.out.println("An user with the same email address already exists");
				if(userExists){
					System.out.println("Username already in use");
				}
			} else {
				userDAO.addUser(user);
			}	
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
				
	}

}
