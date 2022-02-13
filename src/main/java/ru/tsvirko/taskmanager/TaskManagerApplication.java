package ru.tsvirko.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.tsvirko.taskmanager.model.TaskModel;

import java.util.ArrayList;

@SpringBootApplication
public class TaskManagerApplication {


    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }

}
