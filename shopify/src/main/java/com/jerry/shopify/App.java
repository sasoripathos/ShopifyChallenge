package com.jerry.shopify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jerry"})
public class App 
{
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args); 
		System.out.println("Thanks for using shopify!");
	}
}
