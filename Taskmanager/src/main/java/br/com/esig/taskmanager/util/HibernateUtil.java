package br.com.esig.taskmanager.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory = factoryCreator();
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private static SessionFactory factoryCreator() {
		try {
			Configuration configuration = new Configuration().configure();
			
			ServiceRegistry register = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
			SessionFactory factory = configuration.buildSessionFactory();
			
			return factory;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
