package com.socode.todo;

import com.socode.todo.entities.Status;
import com.socode.todo.repositories.StatusRepository;
import com.socode.todo.services.InitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner{
	private InitService initService;

	public TodoApplication(InitService initService) {
		this.initService = initService;
	}
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.initService.run();
	}
}
