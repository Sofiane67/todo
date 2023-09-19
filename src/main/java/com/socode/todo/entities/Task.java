package com.socode.todo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tasks")
public class Task extends TaskModel{
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<SubTask> subTasks = new ArrayList<>();

    public Task() {
        super();
    }
}
