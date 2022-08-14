package com.ecommerce;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory; // Why is SessionFactory Static? - Only 1 SessionFactory per project.
	
	static
	{
		try
		{
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build(); // Builder Pattern
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build(); // Metadata is the heart of Hibernate.
			
			sessionFactory = metaData.getSessionFactoryBuilder().build();			
		}catch(Throwable th)
		{
			throw new ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	
}
