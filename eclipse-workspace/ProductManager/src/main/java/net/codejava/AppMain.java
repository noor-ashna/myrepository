package net.codejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppMain {
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}
}
  

        // Here, the @SpringBootApplication annotation does all the magic stuffs 
        // such as create the web server instance and Spring MVC dispatcher servlet.