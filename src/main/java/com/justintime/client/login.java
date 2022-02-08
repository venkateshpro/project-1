package com.justintime.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.dao.ValidateUser;
import com.justintime.db.HibernateCon;
import com.justintime.model.Employee;
/**
 * @author Sagnik
 *
 */

public class login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email=request.getParameter("id");
		String pwd=request.getParameter("ipass");
		Integer dropdown = Integer.parseInt(request.getParameter("dropdown"));
		
		switch(dropdown) {
		case 1:{
			//Employee   ValidateUser.check(id, pwd)
			if(ValidateUser.check(email, pwd)) {
				HttpSession s=request.getSession(true);
				s.setMaxInactiveInterval(10000);
				s.setAttribute("email",email);
				s.setAttribute("pass", pwd);
				out.println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Employee Login Successful</title>\r\n"
						+ "</head>\r\n"
						+ "<body>");
				out.println("<form method=\"post\" action=\"bookcab\" >\r\n"
						+ "<button type=\"submit\" id=\"login-button\" >Book a Cab</button>\r\n"
						+ "</form>");
				out.println("<form method=\"post\" action=\"BookingHistory\" >\r\n"
						+ "<button type=\"submit\" id=\"login-button\" >Booking History</button>\r\n"
						+ "</form>");
				out.println("</body>\r\n"
						+ "</html>");
//				RequestDispatcher rd=request.getRequestDispatcher("Employee.html");
//				rd.include(request, response);
			}
			else {
				out.println("Wrong Credentials!");
				RequestDispatcher rd=request.getRequestDispatcher("logiin.html");
				rd.include(request, response);
			}
			break;
		}
		case 2:{
			//Manager
			if(ValidateUser.checkMan(email, pwd)) {
				HttpSession s=request.getSession(true);
				s.setMaxInactiveInterval(10000);
				s.setAttribute("id",email);
				s.setAttribute("pass", pwd);
				out.println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Insert title here</title>\r\n"
						+ "</head>\r\n"
						+ "<body>");
				out.println("</body>\r\n"
						+ "</html>");
//				RequestDispatcher rd=request.getRequestDispatcher("Manager.html");
//				rd.include(request, response);
			}
			else {
				out.println("Wrong Credentials!");
				RequestDispatcher rd=request.getRequestDispatcher("logiin.html");
				rd.include(request, response);
			}
			break;
		}
		case 3:{
			//Admin
			if(email.equalsIgnoreCase("admin@emp.com") && pwd.equalsIgnoreCase("admin")) {
				HttpSession s=request.getSession(true);
				s.setMaxInactiveInterval(10000);
				s.setAttribute("id",email);
				s.setAttribute("pass", pwd);
				out.println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Admin</title>\r\n"
						+ "</head>\r\n"
						+ "<body>");
				out.println("<div class=\"sec-container\">\r\n"
						+ "        <h1 class=\"a_form-name\">!!! Welcome Admin !!!</h1>\r\n"
						+ "        <div class=\"select-container\">\r\n"
						+ "            <a href=\"./EmployeeRegistration.html\"><button class=\"Button-admin\">Add Employee</button></a>\r\n"
						+ "            <a href=\"./CabRegistration.html\"><button class=\"Button-admin\">Add Cab</button></a>\r\n"
						+ "            <a href=\"#\"><button class=\"Button-admin\">Assign Cab</button></a>\r\n"
						+ "        </div>\r\n"
						+ "    </div>");
				out.println("</body>\r\n"
						+ "</html>");
//				RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
//				rd.include(request, response);
			}
			else {
				out.println("Wrong Credentials!");
				RequestDispatcher rd=request.getRequestDispatcher("logiin.html");
				rd.include(request, response);
			}
			break;
		}
			
		}
	}

}
