package com.socode.todo.controllers;

import com.socode.todo.dto.ApiResponseDTO;
import com.socode.todo.entities.BoardColumns;
import com.socode.todo.services.BoardColumnsService;
import com.socode.todo.services.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "column", produces = APPLICATION_JSON_VALUE)
public class BoardColumnsController {
    private BoardColumnsService boardColumnsService;
    private ApiResponseDTO apiResponse;

    public BoardColumnsController(BoardColumnsService boardColumnsService){
        this.boardColumnsService = boardColumnsService;
        this.apiResponse = new ApiResponseDTO();
    }

    @GetMapping(path = "boards/{boardId}")
    public ResponseEntity<?> getBoardColumnsByBoardId(@PathVariable int boardId){
        try {
            List<BoardColumns> columns = this.boardColumnsService.getColumnsByBoardId(boardId);
            return ResponseEntity.status(HttpStatus.OK).body(columns);
        }catch(Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getColumnById(@PathVariable int id){
        try{
            BoardColumns columns = this.boardColumnsService.getColumnById(id);
            return ResponseEntity.status(HttpStatus.OK).body(columns);
        }catch(Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage(e.getMessage());
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> editColumn(@PathVariable int id, @RequestBody BoardColumns column){
        try{
            this.boardColumnsService.editColumn(id, column);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setMessage("La colonne a été modifiée avec succées");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }catch(Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage(e.getMessage());
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> removeColumn(@PathVariable int id){
        try{
            this.boardColumnsService.removeColumn(id);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setMessage("La colonne a été supprimée avec succées");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }catch(Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage(e.getMessage());
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }
}
