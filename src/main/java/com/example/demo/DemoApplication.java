package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.demo")
@Slf4j
public class DemoApplication {

	/*
	TODO add file system storage service for book covers
	TODO add controllers and validation
	TODO create live chat inside each book
	TODO create pagination and filters for controllers
	TODO create docs
	TODO add hateoas for controllers
	TODO create a proper system for logging
	TODO add caching for logging
	TODO add caching for controllers
	TODO add tests
	TODO work with accept headers
	TODO add authorization
	TODO add internationalization
	TODO add security headers
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
