package com.justintime.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.db.HibernateCon;
import com.justintime.model.Cab;
import com.justintime.model.Employee;

/**
 * @author Sagnik
 *
 */

public class BuildDatabase {

	public static void main(String[] args) {
		Session session = HibernateCon.getSession().openSession();
		Transaction tx = session.beginTransaction();
		
		

		   
		tx.commit();
		session.close();

	}

}
