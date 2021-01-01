package com.main;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.dao.entity.Mango;

public class FetchMangoByAttributes {
	
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
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter new color");
		String color= scanner.next();
		//if you have primary key of entity
		//Loading entity inside hibernate persistence context
		//hibernate persistence context present inside session
		//session is present inside session factory
		//session factory is ORM tool , ie. hibernate
		//This is called HQL ->> when we write query on class and attributes of it
		// native query - when we write query on table and column of it
		String hql="from Mango where color=:pcolor";
		Query query=session.createQuery(hql);
		query.setParameter("pcolor", color);
		List<Mango> mangos=query.list();
		for(Mango mango:mangos){
			System.out.println("########### = "+mango);
		}
		
		System.out.println("Ahaha it is saved!");
		
	}

}
