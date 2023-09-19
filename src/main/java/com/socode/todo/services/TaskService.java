package com.socode.todo.services;

import com.socode.todo.entities.Category;
import com.socode.todo.entities.Task;
import com.socode.todo.repositories.CategoryRepository;
import com.socode.todo.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private CategoryRepository categoryRepository;

    public TaskService(TaskRepository taskRepository, CategoryRepository categoryRepository){
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    public void createTask(Task task){
        Category existingCategory = categoryRepository.findById(task.getCategory().getId())
                .orElseThrow(() -> new IllegalArgumentException("La catégorie spécifiée n'existe pas"));
        task.setCategory(existingCategory);
        this.taskRepository.save(task);
    }
}
