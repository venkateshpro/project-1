package com.justintime.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.db.HibernateCon;
import com.justintime.model.Cab;

/**
 * @author Sagnik
 *
 */
public class CabRegistrationImpl implements CabRegister{

	public boolean register(Cab c) {
		try {
			Session session = HibernateCon.getSession().openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(c);
			
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
