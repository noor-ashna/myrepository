package com.spring.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.Jocker;
import com.spring.service.JockerService;

public class SpringJockerMain3 {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("jocker-service.xml");
		JockerService jockerService = applicationContext.getBean(JockerService.class);
		
		System.out.println("Data before delete");
		List<Jocker> jockers=jockerService.findAll();
		jockers.forEach(System.out::println);
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Eneter jid");
		int jid = scanner.nextInt();
		jockerService.deleteById(jid);
		
		System.out.println("Data after delete");
		jockers=jockerService.findAll();
		jockers.forEach(System.out::println);
		
	}

}
