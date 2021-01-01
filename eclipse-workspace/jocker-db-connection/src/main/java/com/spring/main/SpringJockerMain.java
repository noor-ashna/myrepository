package com.spring.main;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.Jocker;
import com.spring.service.JockerService;

public class SpringJockerMain {
                                                    // step four
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("jocker-service.xml");
		JockerService jockerService = applicationContext.getBean(JockerService.class);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Eneter name");
		String name = scanner.next();
		System.out.println("Eneter email");
		String email = scanner.next();

		System.out.println("Eneter age");
		int age = scanner.nextInt();
		Jocker jocker = new Jocker();
		jocker.setAge(age);
		jocker.setEmail(email);
		jocker.setName(name);
		jocker.setPrice(new Random().nextFloat());
		String result=jockerService.save(jocker);
		System.out.println(result);
		
		List<Jocker> jockers=jockerService.findAll();
		jockers.forEach(System.out::println);
	}

}
