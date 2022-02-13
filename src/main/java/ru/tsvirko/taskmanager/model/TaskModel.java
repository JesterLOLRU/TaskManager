package ru.tsvirko.taskmanager.model;

import java.time.LocalDateTime;

public class TaskModel {
    private String name;
    private String description;
    private LocalDateTime timestamp;
    private final int id;

    public TaskModel(String name, String description) {
        this.name = name;
        this.description = description;
        this.timestamp = LocalDateTime.now();
        this.id = (int) (Math.random()*1000);
    }

    public TaskModel(String name) {
        this.name = name;
        this.description = "empty description";
        this.timestamp = LocalDateTime.now();
        this.id = (int) (Math.random()*1000);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
