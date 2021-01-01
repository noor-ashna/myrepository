package com.orm.personMain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.orm.entity.Passport;
import com.orm.entity.Person;
import com.orm.entity.Vehicle;

public class FetchPersonPassportSave {
	

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
			Session sessionObj=buildSessionFactory().getCurrentSession();
			 // Getting Transaction Object From Session Object
	        sessionObj.beginTransaction();
	       
	        Person person=new Person();
	        person.setEmail("noor@gmail.com");
	        person.setName("Noor Ashna");
	    	
	        Passport passport=new Passport();
	    	passport.setDob("12-8-1213");
	    	passport.setNumber("5345454545");
	    	//This is important
	    	passport.setPerson(person);
	    	
	    	//Save always child record!
	    	sessionObj.save(passport);
	            
	        sessionObj.getTransaction().commit();
			
		}

}
