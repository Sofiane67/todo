package com.socode.todo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@MappedSuperclass
public abstract class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @NotBlank
    protected String title;
    @NotBlank
    protected String description;
    protected Date dueDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    protected Status status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    protected Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "priority_id")
    protected Priority priority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
