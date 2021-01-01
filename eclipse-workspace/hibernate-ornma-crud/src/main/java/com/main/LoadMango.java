package com.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.dao.entity.Mango;

public class LoadMango {
	
	// This Method Is Used To Create The Hibernate's SessionFactory Object
    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration(); 
        configObj.configure("hibernate.cfg.xml");
        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
        // Creating Hibernate SessionFactory Instance
        SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

	public static void main(String[] args) {
		//Creating session factory and returing a session from it
		//Session is an interface to interact with ORM
		Session session=buildSessionFactory().openSession();
		//Here we are writing query on class and on it;s attributes
		//That;s why it is called HQL - Hibernate Query Language
		Query query=session.createQuery("from Mango");     // Mango is class name
		List<Mango> mangos=query.list();
		for(Mango mango:mangos){
			System.out.println(mango); 
		}
	}

}
