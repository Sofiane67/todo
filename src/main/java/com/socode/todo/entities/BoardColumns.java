package com.socode.todo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "board_columns")
public class BoardColumns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String name;

    private int orderColumn;
    private boolean isDisplayed;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    @NotEmpty
    private Board board;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    @NotEmpty
    private Status status;

    public BoardColumns(){

    }

    public BoardColumns(int id, String name, int orderColumn, boolean isDisplayed, Board board, Status status){
        this.id = id;
        this.name = name;
        this.orderColumn = orderColumn;
        this.isDisplayed = true;
        this.board = board;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(int orderColumn) {
        this.orderColumn = orderColumn;
    }

    public boolean isDisplayed() {
        return isDisplayed;
    }

    public void setDisplayed(boolean displayed) {
        isDisplayed = displayed;
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
