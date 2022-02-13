package ru.tsvirko.taskmanager.service;

import ru.tsvirko.taskmanager.model.TaskModel;

import java.util.ArrayList;

public interface TaskService {
    String createTask(String name, String description);
    String deleteTask(int id);
    TaskModel getTask(int id);
    ArrayList<TaskModel> sortTaskList();
    String editTask(int id, String name, String description);
}
