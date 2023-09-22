package com.socode.todo.services;

import com.socode.todo.entities.Board;
import com.socode.todo.repositories.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public List<Board> getBoards(){
        return this.boardRepository.findAll();
    }
    public Board getBoard(int id){
        return this.boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Le board spécifiée n'existe pas"));
    }
    public void createBoard(Board board){
        this.boardRepository.save(board);
    }

    public void editBoard(Board boardEdited, int id){
        Board board = this.getBoard(id);
        board.setName(boardEdited.getName());
        this.boardRepository.save(board);
    }

    public void removeBoard(int id){
        this.boardRepository.deleteById(id);
    }
}
