package com.justintime.db;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.justintime.model.BookingDetails;
import com.justintime.model.BookingStatus;
import com.justintime.model.Cab;
import com.justintime.model.Employee;
import com.justintime.model.Request;

/**
 * @author Sagnik
 *
 */

public class HibernateCon {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSession() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/project1");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "org.hibernate.context.internal.ThreadLocalSessionContext");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Cab.class);
				configuration.addAnnotatedClass(Employee.class);
				configuration.addAnnotatedClass(BookingStatus.class);
				configuration.addAnnotatedClass(BookingDetails.class);
				configuration.addAnnotatedClass(Request.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}