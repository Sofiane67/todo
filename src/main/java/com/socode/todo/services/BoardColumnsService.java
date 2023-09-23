package com.socode.todo.services;

import com.socode.todo.entities.Board;
import com.socode.todo.entities.BoardColumns;
import com.socode.todo.entities.Status;
import com.socode.todo.repositories.BoardColumnsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardColumnsService {
    private BoardColumnsRepository boardColumnsRepository;
    private BoardService boardService;
    private StatusService statusService;

    public BoardColumnsService (BoardColumnsRepository boardColumnsRepository, BoardService boardService, StatusService statusService){
        this.boardColumnsRepository = boardColumnsRepository;
        this.boardService = boardService;
        this.statusService = statusService;
    }

    public List<BoardColumns> getColumnsByBoardId(int id){
        return this.boardColumnsRepository.findBoardColumnsByBoardIdOrderByOrderColumnAsc(id);
    }

    public BoardColumns getColumnById(int id){
        return this.boardColumnsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("La colonne n'existe pas"));
    }

    public int getNumberOfColumnsByBoardId(int id){
        return this.boardColumnsRepository.countBoardColumnsByBoardId(id);
    }

    public void createBoardColumns(int boardId, int statusId, BoardColumns columns){
        Board board = this.boardService.getBoardById(boardId);
        Status status = this.statusService.getStatusById(statusId);

        if(board != null && status != null){

            columns.setBoard(board);
            columns.setStatus(status);

            System.out.println(board.getName());
            System.out.println(status.getName());

            int orderColumn = this.getNumberOfColumnsByBoardId(board.getId()) + 1;
            columns.setOrderColumn(orderColumn);

            boardColumnsRepository.save(columns);
        }
    }

    public void editColumn(int id, BoardColumns editedColumn){
        BoardColumns columns = this.getColumnById(id);

        if(columns != null){
            columns.setName(editedColumn.getName());
            columns.setOrderColumn(editedColumn.getOrderColumn());
            columns.setDisplayed(editedColumn.isDisplayed());
            this.boardColumnsRepository.save(columns);
        }
    }

    public void removeColumn(int id){
        this.boardColumnsRepository.deleteById(id);
    }


}
