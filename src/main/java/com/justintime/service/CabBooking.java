package com.justintime.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.dao.Booking;
import com.justintime.dao.BookingImpl;
import com.justintime.db.HibernateCon;

/**
 * @author Sagnik
 *
 */

public class CabBooking extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("Welcome to Cab booking <br>");
		out.println("Here Employee books a cab");
		//out.print("<form> </form>");
		HttpSession s=request.getSession(true);
		String id = (String)(s.getAttribute("id"));
		Booking b = new BookingImpl();
		boolean confirm = b.requestCab();
		if(confirm)
			out.println("Cab Requested successfully");
		else
			out.println("Couldn't Request your Cab");
		
	}

}
