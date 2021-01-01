package com.main;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.dao.entity.Mango;

public class UpdateMangoMain {
	
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
		//Creating session factory and returning a session from it
		//Session is an interface to interact with ORM
		Session session=buildSessionFactory().openSession();
		session.getTransaction().begin();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter mid");
		int mid=scanner.nextInt();
		System.out.println("Enter new price");
		float price= scanner.nextFloat();
		
		System.out.println("Enter new color");
		String color= scanner.next();
		//if you have primary key of entity
		//Loading entity inside hibernate persistence context
		//hibernate persistence context present inside session
		//session is present inside session factory
		//session factory is ORM tool , ie. hibernate
		Mango mango=(Mango)session.get(Mango.class, mid);
		
		//only change the state of the entity loaded
		//inside hibernate persistence context
		mango.setColor(color);
		mango.setPrice(price);
		
		System.out.println("Ahaha it is saved!");
		
		session.getTransaction().commit();
	}

}
