package com.socode.todo.services;

import com.socode.todo.entities.Task;
import com.socode.todo.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void createTask(Task task){
        this.taskRepository.save(task);
    }
}
