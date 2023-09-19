package com.socode.todo;

import com.socode.todo.services.InitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	private InitService initService;

	public TodoApplication(InitService initService) {
		this.initService = initService;
	}
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.initService.setStatus();
		this.initService.setCategories();
		this.initService.setPriority();
		this.initService.setTags();
	}
}
