package ru.tsvirko.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tsvirko.taskmanager.model.TaskModel;
import ru.tsvirko.taskmanager.service.TaskService;

import java.util.ArrayList;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;



    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createTask(@RequestParam(required = false) String name,
                             @RequestParam(required = false) String description) {

        return taskService.createTask(name, description);
    }

    @GetMapping("/delete")
    @ResponseBody
    public String deleteTask(@RequestParam int id) {
        return taskService.deleteTask(id);
    }

    @GetMapping("/get")
    @ResponseBody
    public TaskModel getTask(@RequestParam int id) {
        return taskService.getTask(id);
    }

    @GetMapping("/list")
    @ResponseBody
    public ArrayList<TaskModel> getTaskList() {
        return taskService.sortTaskList();
    }

    @GetMapping("/edit")
    @ResponseBody
    public String editTask(@RequestParam int id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false)  String description) {
        return taskService.editTask(id, name, description);
    }
}
