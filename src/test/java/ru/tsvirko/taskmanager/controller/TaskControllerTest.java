package ru.tsvirko.taskmanager.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.tsvirko.taskmanager.model.TaskModel;
import ru.tsvirko.taskmanager.service.TaskService;
import ru.tsvirko.taskmanager.service.TaskServiceImpl;

@ContextConfiguration(classes = {TaskController.class})
@ExtendWith(SpringExtension.class)
class TaskControllerTest {
    @Autowired
    private TaskController taskController;

    @MockBean
    private TaskService taskService;

    @Test
    void testCreateTask() throws Exception {
        when(this.taskService.createTask((String) any(), (String) any())).thenReturn("Create Task");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/task/create");
        MockMvcBuilders.standaloneSetup(this.taskController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Create Task"));
    }

    @Test
    void testCreateTask2() throws Exception {
        when(this.taskService.createTask((String) any(), (String) any())).thenReturn("Create Task");
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/task/create");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.taskController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Create Task"));
    }

    @Test
    void testDeleteTask() throws Exception {
        when(this.taskService.deleteTask(anyInt())).thenReturn("Delete Task");
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/task/delete");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.taskController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Task"));
    }

    @Test
    void testGetTask() {
        assertNull((new TaskController(new TaskServiceImpl())).getTask(1));
    }

    @Test
    void testGetTask2() {
        TaskService taskService = mock(TaskService.class);
        TaskModel taskModel = new TaskModel("Name");
        when(taskService.getTask(anyInt())).thenReturn(taskModel);
        TaskController taskController = new TaskController(taskService);
        assertSame(taskModel, taskController.getTask(1));
        verify(taskService).getTask(anyInt());
        assertTrue(taskController.getTaskList().isEmpty());
    }

    @Test
    void testEditTask() throws Exception {
        when(this.taskService.editTask(anyInt(), (String) any(), (String) any())).thenReturn("Edit Task");
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/task/edit");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.taskController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Edit Task"));
    }

    @Test
    void testGetTaskList() throws Exception {
        when(this.taskService.sortTaskList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/task/list");
        MockMvcBuilders.standaloneSetup(this.taskController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetTaskList2() throws Exception {
        when(this.taskService.sortTaskList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/task/list");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.taskController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

