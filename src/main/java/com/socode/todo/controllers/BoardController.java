package com.socode.todo.controllers;

import com.socode.todo.dto.ApiResponseDTO;
import com.socode.todo.entities.Board;
import com.socode.todo.services.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "board", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class BoardController {
    private BoardService boardService;
    private ApiResponseDTO apiResponse;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
        this.apiResponse = new ApiResponseDTO();
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO> createBoard(@RequestBody Board board){
        try{
            this.boardService.createBoard(board);
            apiResponse.setStatusCode(HttpStatus.CREATED.value());
            apiResponse.setStatus(HttpStatus.CREATED);
            apiResponse.setMessage("Board créé avec succès");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }catch(Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }
}
