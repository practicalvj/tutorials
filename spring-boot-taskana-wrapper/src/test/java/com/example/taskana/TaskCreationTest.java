package com.example.taskana;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import pro.taskana.task.api.TaskService;
import pro.taskana.task.api.models.Task;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext
class TaskCreationTest {

    @Autowired
    private TaskService taskService;

    @Test
    void testTaskCreation() throws Exception {
        Task task = taskService.newTask("USER_1");
        task.setName("JUnit Task");
        Task created = taskService.createTask(task);
        Task found = taskService.getTask(created.getId());
        assertThat(found).isNotNull();
    }
}
