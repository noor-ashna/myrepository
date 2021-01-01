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

public class SaveMango {
	
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
		System.out.println("Enter color");
		String color=scanner.next();
		System.out.println("Enter price");
		float price= scanner.nextFloat();

		Mango mango=new Mango();
		mango.setColor(color);
		mango.setPrice(price);
		mango.setTaste("sour");
		mango.setUrl("http://localhost:43");
		mango.setDescription("Do not eat mango daily!@!!");
		mango.setDob(new Timestamp(new Date().getTime()));
		
		session.save(mango);		
		
		System.out.println("Ahaha it is saved!");
		
		session.getTransaction().commit();
	}

}
