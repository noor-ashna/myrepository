package com.rab3tech.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rab3tech.vo.Dog;
import com.rab3tech.vo.DogWrapper;

//This is controller which can expose data into JSON format
@RestController
@RequestMapping("/v4")
public class DogRestController { 
	
	// {
 //   "did": 100,
   // "name": "Omehaha",
   // "color": "yeloow",
   // "email": "j324r322020@gmail.com",
   // "tail": 4,
   // "breed": "abc",   
   // "photo": null
//}
	//@RequestBody - reading json data from incoming request and map into Dog object
	@PostMapping("/dogs")
	public Dog createDog(@RequestBody Dog dog){     // we passed the parameter so it will give us a particular dog
		System.out.println(dog);
		System.out.println(dog);
		System.out.println(dog);
		System.out.println(dog);
		//return dog object
		return dog;
	}
	
	
	@GetMapping("/dogs")
	public Dog getDog(@RequestParam  int did){  
		Dog dog=new Dog(did,"Jacky","red","javahunk2020@gmail.com",1,"Oeu",null);
		//return dog object
		return dog;
	}
	
	@GetMapping("/alldogs")
	public DogWrapper getDogs(){   // Here we do not pass the parameter so we will get all dogs
		Dog dog1=new Dog(100,"Jacky","red","javahunk2020@gmail.com",1,"Oeu",null);
		Dog dog2=new Dog(200,"Monkey","white","javahunk100@gmail.com",2,"opeoeu",null);
		ArrayList<Dog> dogs=new ArrayList<>();
		dogs.add(dog1);
		dogs.add(dog2);
		DogWrapper dogWrapper=new DogWrapper();
		dogWrapper.setDogs(dogs);
		//return dog object
		return dogWrapper;
	}
	

}
