package com.rab3tech.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//This is controller which can expose data into JSON format
@RestController
@RequestMapping("/v4") 
public class SignupRestController {
	
	@GetMapping("/dogs")
	public Dog getDog(@RequestParam int did) {   // If you pass the parameter it will give your a particular dog.
		
		Dog dog = new Dog (did, "Jacky","White","dog123@yahoo.com",1,"Popy",null);  
		return dog;  
	   }
	
	@GetMapping("/alldogs")
	public ArrayList<Dog>getDogs() {            // We use ArrayList so it will work for XML while List does not work for XML
		
		Dog dog1 = new Dog(80, "Tomy","White","dog123@yahoo.com",1,"Popy",null);
		Dog dog2 = new Dog(90,"Backy","blue","yourdog@gmail.com",1,"Koti",null);
		ArrayList<Dog> dogs= new ArrayList<>(); 
		dogs.add(dog1);
		dogs.add(dog2);
		return dogs; 
		
	   }
  }
