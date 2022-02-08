package com.justintime.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.justintime.dao.RegisterEmployee;
import com.justintime.dao.RegisterEmployeeImpl;
import com.justintime.model.Employee;

/**
 * @author Sagnik
 *
 */

public class EmployeeRegistration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Redirected after Employee Registration details");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String dept = request.getParameter("dept");
		Integer manager = Integer.parseInt(request.getParameter("dropdown"));
		String pwd = name+"123";
		
		Employee emp = new Employee(name,email,manager,1,dept,pwd);
		
//		out.println("Send Employee object to database");
//		out.println(manager);
		
		RegisterEmployee rEmp = new RegisterEmployeeImpl();
		
		Boolean confirm = rEmp.register1(emp);
		
		if(confirm)
			out.println("Registered Successfully");
		else
			out.println("Error Occoured");
	}

}
