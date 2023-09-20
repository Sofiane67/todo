package com.socode.todo.controllers;

import com.socode.todo.services.TaskService;
import dto.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "task", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class TaskController {

    public TaskController(TaskService taskService){}

}
