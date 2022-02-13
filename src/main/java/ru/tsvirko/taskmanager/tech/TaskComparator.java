package ru.tsvirko.taskmanager.tech;

import ru.tsvirko.taskmanager.model.TaskModel;

import java.util.Comparator;

public class TaskComparator implements Comparator<TaskModel> {
    @Override
    public int compare(TaskModel o1, TaskModel o2) {
        return Integer.compare(o2.getId(), o1.getId());
    }
}
