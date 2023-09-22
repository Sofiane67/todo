package com.socode.todo.controllers;

import com.socode.todo.dto.ApiResponseDTO;
import com.socode.todo.entities.Status;
import com.socode.todo.services.StatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "status", produces = APPLICATION_JSON_VALUE)
public class StatusController {
    private StatusService statusService;
    private ApiResponseDTO apiResponse;

    public StatusController(StatusService statusService){
        this.statusService = statusService;
        this.apiResponse = new ApiResponseDTO();
    }

    @GetMapping
    public ResponseEntity<?> getStatus(){
        try{
            List<Status> status = this.statusService.getStatus();
            return ResponseEntity.status(HttpStatus.OK).body(status);
        }catch(Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getStatusById(@PathVariable int id){
        try{
            Status status = this.statusService.getStatusById(id);
            return ResponseEntity.status(HttpStatus.OK).body(status);
        }catch(Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseDTO> createStatus(@RequestBody Status status){
        try{
            this.statusService.createStatus(status);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setMessage("Le status a été créé avec succées");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }catch(Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }

    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editStatus(@PathVariable int id, @RequestBody Status status){
        try{
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setMessage("Le status a été modifié avec succées");
            this.statusService.editStatus(id, status);
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }catch (Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> removeStatus(@PathVariable int id){
        try{
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setMessage("Le status a été supprimé avec succées");
            this.statusService.removeStatus(id);
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }catch (Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }
}
