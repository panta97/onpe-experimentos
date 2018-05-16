package com.onpe;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class OnpeApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnpeApplication.class, args);
		
		 System.out.println("Press 'Enter' to terminate");
	        new Scanner(System.in).nextLine();
	        System.out.println("Exiting");
	        System.exit(1);
	}
	
	
	
}

