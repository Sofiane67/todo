package com.socode.todo.controllers;

import com.socode.todo.dto.ApiResponseDTO;
import com.socode.todo.entities.Task;
import com.socode.todo.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "task", produces = APPLICATION_JSON_VALUE)
public class TaskController {
    private TaskService taskService;
    private ApiResponseDTO apiResponse;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
        this.apiResponse = new ApiResponseDTO();
    }

    @GetMapping
    public ResponseEntity<?> getTasks(){
        try{
            List<Task> tasks = this.taskService.getTasks();
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setStatus(HttpStatus.OK);
            return ResponseEntity.status(apiResponse.getStatus()).body(tasks);
        }catch (Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getTaskById(@PathVariable int id){
        try{
            Task task = this.taskService.getTaskById(id);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setStatus(HttpStatus.OK);
            return ResponseEntity.status(apiResponse.getStatus()).body(task);
        }catch (Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTask(@RequestBody Task task){
        try{
            this.taskService.createTask(task);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setMessage("Tâche créée avec succès");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }catch (Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editTask(@PathVariable int id, @RequestBody Task task){
        try{
            this.taskService.editTask(id, task);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setMessage("Tâche modifiée avec succès");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }catch (Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> removeTask(@PathVariable int id){
        try{
            this.taskService.removeTask(id);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setMessage("Tâche supprimée avec succès");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }catch (Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }

}
