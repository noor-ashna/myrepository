package com.auth;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationUpDownListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("@)@(@(@(*@(@Application is UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("@)@(@(@(*@(@Application is UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("@)@(@(@(*@(@Application is UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("@)@(@(@(*@(@Application is UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("@)@(@(@(*@(@Application is UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("@)@(@(@(*@(@Application is DOWN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("@)@(@(@(*@(@Application is DOWN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("@)@(@(@(*@(@Application is DOWN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("@)@(@(@(*@(@Application is DOWN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("@)@(@(@(*@(@Application is DOWN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

}
