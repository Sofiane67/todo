package com.socode.todo.controllers;

import com.socode.todo.dto.ApiResponseDTO;
import com.socode.todo.entities.Subtask;
import com.socode.todo.services.SubtaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "subtask", produces = APPLICATION_JSON_VALUE)
public class SubtaskController {
    private SubtaskService subtaskService;
    private ApiResponseDTO apiResponse;
    public SubtaskController(SubtaskService subtaskService){
        this.subtaskService = subtaskService;
        this.apiResponse = new ApiResponseDTO();
    }

    @GetMapping(path = "task/{taskId}")
    public ResponseEntity<?> getSubtasks(@PathVariable int taskId){
        try{
            List<Subtask> tasks = this.subtaskService.getSubtasks(taskId);
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
    public ResponseEntity<?> getSubtaskById(@PathVariable int id){
        try{
            Subtask task = this.subtaskService.getSubtaskById(id);
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
    @PostMapping(path = "task/{taskId}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createSubtask(@PathVariable int taskId, @RequestBody Subtask subtask){
        try{
            this.subtaskService.createSubTask(taskId, subtask);
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
    public ResponseEntity<?> editSubtask(@PathVariable int id, @RequestBody Subtask subtask){
        try{
            this.subtaskService.editSubtask(id, subtask);
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
    public ResponseEntity<?> removeSubtask(@PathVariable int id){
        try{
            this.subtaskService.removeSubTask(id);
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
