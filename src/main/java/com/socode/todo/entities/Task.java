package com.socode.todo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task extends TaskModel{
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Task(){
        super();
    }

    public Task(Board board, Status status){
        this.board = board;
        this.status = status;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
