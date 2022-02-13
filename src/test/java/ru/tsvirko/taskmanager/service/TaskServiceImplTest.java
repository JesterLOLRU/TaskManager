package ru.tsvirko.taskmanager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.tsvirko.taskmanager.model.TaskModel;

@ContextConfiguration(classes = {TaskServiceImpl.class})
@ExtendWith(SpringExtension.class)
class TaskServiceImplTest {
    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @Test
    void testCreateTask() {
        this.taskServiceImpl.createTask("Name", "something");
        TaskModel getResult = TaskServiceImpl.getTaskList().get(0);
        assertEquals("Name", getResult.getName());
        assertEquals("something", getResult.getDescription());
    }

    @Test
    void testGetTask() {
        assertNull(this.taskServiceImpl.getTask(0));
    }


    @Test
    void testDeleteTask() {
        assertEquals("Таска с id 1 не найдена.", this.taskServiceImpl.deleteTask(1));
        assertEquals("Таска с id 263 не найдена.", this.taskServiceImpl.deleteTask(263));
    }


    @Test
    void testEditTask() {
        assertEquals("Имя или описание не были переданы, ничего не изменено",
                this.taskServiceImpl.editTask(640, null, null));
    }
}

