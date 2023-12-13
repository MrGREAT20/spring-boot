package com.spring_boot_app.first_spring_proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringProjApplication.class, args);
	}

}

/**
 * Create a Task Manager API
 * 
 * Create a Task (wuth following attributes)
 * -> title
 * -> due date
 * -> Status (Pending, In Progress, Completed)
 * 
 * Update a Task
 * Delete a Task
 * List all the Task
 */