package com.socode.todo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "subtasks")
public class Subtask extends TaskModel{
    private boolean isCompleted;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task task;

    public Subtask(){
        super();
    }

    public Subtask(boolean isCompleted, Task task){
        this.isCompleted = false;
        this.task = task;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
