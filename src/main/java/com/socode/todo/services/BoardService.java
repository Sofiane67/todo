package com.socode.todo.services;

import com.socode.todo.entities.Board;
import com.socode.todo.repositories.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public void createBoard(Board board){
        this.boardRepository.save(board);
    }
}
