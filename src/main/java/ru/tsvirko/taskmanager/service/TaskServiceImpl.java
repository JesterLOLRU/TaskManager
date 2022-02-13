package ru.tsvirko.taskmanager.service;

import org.springframework.stereotype.Service;
import ru.tsvirko.taskmanager.model.TaskModel;
import ru.tsvirko.taskmanager.tech.TaskComparator;


import java.time.LocalDateTime;
import java.util.ArrayList;


@Service
public class TaskServiceImpl implements TaskService {
    public static ArrayList<TaskModel> taskList = new ArrayList<>();

    @Override
    public String createTask(String name, String description) {
        TaskModel task = new TaskModel(name, description);
        taskList.add(task);
        return "Таска создана успешна." +
                "Её id = " + task.getId();
    }

    @Override
    public TaskModel getTask(int id) {
        return taskList.stream().filter(task -> id == task.getId()).findFirst().orElse(null);
    }

    @Override
    public String deleteTask(int id) {
        TaskModel task = getTask(id);
        if (task != null) {
            taskList.remove(task);
            return "Таска с id " + id + " удалена успешно.";
        } else {
            return "Таска с id " + id + " не найдена.";
        }
    }

    @Override
    public ArrayList<TaskModel> sortTaskList() {
        taskList.sort(new TaskComparator());
        return taskList;
    }

    @Override
    public String editTask(int id, String name, String description) {
        TaskModel task = getTask(id);
        if (name != null && description != null) {
            task.setDescription(description);
            task.setName(name);
            task.setTimestamp(LocalDateTime.now());
            return "Имя и описание таски id " + id + " успешно изменены";
        } else if (name != null) {
            task.setName(name);
            task.setTimestamp(LocalDateTime.now());
            return "Имя таски id " + id + " успешно изменено";
        } else if (description != null) {
            task.setDescription(description);
            task.setTimestamp(LocalDateTime.now());
            return "Описание таски id " + id + " успешно изменено";
        } else {
            return "Имя или описание не были переданы, ничего не изменено";
        }
    }

    public static ArrayList<TaskModel> getTaskList() {
        return taskList;
    }
}
