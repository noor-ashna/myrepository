package com.spring.main;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.Jocker;
import com.spring.service.JockerService;

public class SpringJockerMain2 {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("jocker-service.xml");
		JockerService jockerService = applicationContext.getBean(JockerService.class);
		List<Jocker> jockers=jockerService.findAll();
		jockers.forEach(System.out::println);
	}

}
