package com.socode.todo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.yaml.snakeyaml.events.Event;

@Entity
@Table(name = "boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String name;

    public Board(){};
    public Board(int id, String name){
        this.id = id;
        this.name = name;
    };

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
}
