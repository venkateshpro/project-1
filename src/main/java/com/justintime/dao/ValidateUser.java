package com.justintime.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.db.HibernateCon;
import com.justintime.model.Employee;

public class ValidateUser {
	public static boolean check(String email,String pass) {
		boolean  st = false;
		try {
			Session session = HibernateCon.getSession().openSession();
			Transaction tx = session.beginTransaction();
			
			Query q=session.createQuery("from Employee e where e.email="+ email+" and e.password="+ pass); //HQL
			List<Employee> elist=q.list();
			
			if(elist.size()==1)
				st=true;
			
			tx.commit();
			session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return st;
	}
	
	public static boolean checkMan(String email,String pass) {
		boolean  st = false;
		try {
			Session session = HibernateCon.getSession().openSession();
			Transaction tx = session.beginTransaction();
			
			Query q=session.createQuery("from Employee e where e.email="+ email+" and e.password="+ pass+" and e.manager=1"); //HQL
			List<Employee> elist=q.list();
			
			if(elist.size()==1)
				st=true;
			
			tx.commit();
			session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return st;
	}

}
