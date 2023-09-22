package com.socode.todo;

import com.socode.todo.entities.Status;
import com.socode.todo.repositories.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TodoApplication {

	public TodoApplication() {}
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
}
