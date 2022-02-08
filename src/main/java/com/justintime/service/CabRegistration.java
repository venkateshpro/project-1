package com.justintime.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.justintime.dao.CabRegistrationImpl;
import com.justintime.model.Cab;
import com.justintime.dao.CabRegister;

/**
 * @author Sagnik
 *
 */

public class CabRegistration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Redirected after Cab Registration details");
		
		Integer cabNo = Integer.parseInt(request.getParameter("cabNo"));
		String dName = request.getParameter("dName");
		String dMobile = request.getParameter("dMobile");
		
		Cab cab = new Cab(cabNo,1,dName,dMobile);
		
		out.println("Send Cab object to database");
		CabRegister cReg = new CabRegistrationImpl();
		boolean confirm = cReg.register(cab);
		
		if(confirm)
			out.println("Registered Successfully");
		else
			out.println("Error Occoured");
	}

}
