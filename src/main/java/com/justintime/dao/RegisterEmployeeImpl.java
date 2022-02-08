package com.justintime.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.justintime.db.HibernateCon;
import com.justintime.model.Employee;

public class RegisterEmployeeImpl implements RegisterEmployee{

	public Boolean register1(Employee emp) {
		
		try {
			Session session = HibernateCon.getSession().openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(emp);
			
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
