package com.demo2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to testing");
		SpringApplication.run(DemoApplication.class, args);
	}

}
