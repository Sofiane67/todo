package com.socode.todo.services;

import com.socode.todo.entities.Board;
import com.socode.todo.entities.BoardColumns;
import com.socode.todo.entities.Status;
import com.socode.todo.entities.Task;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    private BoardService boardService;
    private StatusService statusService;
    private BoardColumnsService boardColumnsService;
    private TaskService taskService;

    public InitService(BoardService boardService, StatusService statusService, BoardColumnsService boardColumnsService, TaskService taskService){
        this.boardService = boardService;
        this.statusService = statusService;
        this.boardColumnsService = boardColumnsService;
        this.taskService = taskService;
    }

    public void setBoard(){
        Board board = new Board();
        board.setName("Todo APP");
        this.boardService.createBoard(board);
    }

    public void setStatus(){
        String[] stList = {"A faire", "En cours", "Terminée"};
        for (String item : stList) {
            Status status = new Status();
            status.setName(item);
            Status addedStatus = this.statusService.createStatus(status);
            BoardColumns columns = new BoardColumns();
            columns.setName(addedStatus.getName());
            this.boardColumnsService.createBoardColumns(1, addedStatus.getId(), columns);
        }
    }

    public void run(){
        this.setBoard();
        this.setStatus();
    }
}
