package com.stattracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.stattracker"})
public class StatTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatTrackerApplication.class, args);
	}

}
