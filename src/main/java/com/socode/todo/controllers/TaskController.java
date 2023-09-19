package com.socode.todo.controllers;

import com.socode.todo.entities.Task;
import com.socode.todo.services.TaskService;
import dto.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "task", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class TaskController {
    private TaskService taskService;
    private ApiResponseDTO apiResponse;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
        apiResponse = new ApiResponseDTO();
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO> createTask(@RequestBody Task task){
        try {
            this.taskService.createTask(task);
            apiResponse.setStatus(HttpStatus.CREATED.value());
            apiResponse.setMessage("Tâche créée avec succès");
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
        }catch (Exception e){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
        }
    }
}
