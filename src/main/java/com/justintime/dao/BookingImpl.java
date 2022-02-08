package com.justintime.dao;

/**
 * @author Sagnik
 *
 */

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.db.HibernateCon;

public class BookingImpl implements Booking{

	public boolean requestCab() {
		
		Session session = HibernateCon.getSession().openSession();
		Transaction tx = session.beginTransaction();
		

		   
		tx.commit();
		session.close();
		return false;
	}

}
