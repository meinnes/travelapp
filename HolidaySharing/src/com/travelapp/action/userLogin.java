package com.travelapp.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userLogin extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String user = req.getParameter("username");
		
		if(req.getParameter("password").equals("samplepass")){
			RequestDispatcher rd = req.getRequestDispatcher("userAccount.jsp");
			req.setAttribute("user", user);
			//System.out.println(req.getAttribute("user"));
			rd.forward(req, res);
		}
		else{
			out.print("Wrong username or password");
		}
	}
}
