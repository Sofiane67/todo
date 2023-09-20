package com.socode.todo;

import com.socode.todo.entities.Status;
import com.socode.todo.repositories.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner{
	private StatusRepository statusRepository;
	public TodoApplication(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		List<Status> statusList = new ArrayList();
		String[] statusL = {"À faire", "En cours", "Terminée" };
		for (String item:statusL) {
			Status status = new Status();
			status.setName(item);
			statusList.add(status);
		}

		this.statusRepository.saveAll(statusList);
	}
}
