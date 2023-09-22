package com.socode.todo.controllers;

import com.socode.todo.dto.ApiResponseDTO;
import com.socode.todo.entities.Board;
import com.socode.todo.services.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "board")
public class BoardController {
    private BoardService boardService;
    private ApiResponseDTO apiResponse;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
        this.apiResponse = new ApiResponseDTO();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBoards(){
        try {
            List<Board> boards = this.boardService.getBoards();
            return ResponseEntity.status(HttpStatus.OK).body(boards);

        }catch (Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setMessage("Impossible d'obtenir la liste des boards, un erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBoard(@PathVariable int id){
        try{
            Board board = this.boardService.getBoard(id);
            return ResponseEntity.status(HttpStatus.OK).body(board);
        }catch(Exception e){
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(e);
        }
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
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

    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseDTO> editBoard(@PathVariable int id, @RequestBody Board board){
        try{
            this.boardService.editBoard(board, id);
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setMessage("Le board à été modifié avec succès");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }catch(Exception e){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> removeBoard(@PathVariable int id){
        try{
            this.boardService.removeBoard(id);
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setMessage("Le board à été supprimé avec succès");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }catch(Exception e){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("Une erreur s'est produite");
            return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
        }
    }
}
