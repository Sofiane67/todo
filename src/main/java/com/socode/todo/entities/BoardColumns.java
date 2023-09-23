package com.socode.todo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "board_columns", uniqueConstraints = {@UniqueConstraint(columnNames = {"board_id", "status_id"})})
public class BoardColumns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    private int orderColumn;
    private boolean isDisplayed;

    @ManyToOne
    @JoinColumn(name = "board_id")
    @NotNull
    private Board board;

    @ManyToOne
    @JoinColumn(name = "status_id")
    @NotNull
    private Status status;

    public BoardColumns(){

    }

    public BoardColumns(int id, String name, int orderColumn, boolean isDisplayed, Board board, Status status){
        this.id = id;
        this.name = name;
        this.orderColumn = orderColumn;
        this.isDisplayed = isDisplayed;
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
