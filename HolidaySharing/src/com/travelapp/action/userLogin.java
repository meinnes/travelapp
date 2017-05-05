package com.travelapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travelapp.dao.UserDAOImpl;
import com.travelapp.interfaces.UserDAO;
import com.travelapp.vo.User;

public class userLogin extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
				
		UserDAO userDAO = new UserDAOImpl();
		try {
			boolean logged = userDAO.login(req.getParameter("userName"), req.getParameter("password"));

			if(logged){
				RequestDispatcher rd = req.getRequestDispatcher("userAccount.jsp");
				req.setAttribute("user", userDAO.getUser(req.getParameter("userName")).getFirstName());
				rd.forward(req, res);
			}
			else{
			System.out.println("Incorrect username or password");
			}

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
	}
}
