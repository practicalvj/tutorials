package com.example.taskana;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pro.taskana.TaskanaEngine;
import pro.taskana.task.api.models.Task;
import pro.taskana.task.api.TaskService;

@Component
public class TaskProducer implements CommandLineRunner {

    private final TaskService taskService;

    public TaskProducer(TaskanaEngine taskanaEngine) {
        this.taskService = taskanaEngine.getTaskService();
    }

    @Override
    public void run(String... args) throws Exception {
        Task task = taskService.newTask("USER_1");
        task.setName("Sample Task");
        taskService.createTask(task);
        System.out.println("Created task: " + task.getId());
    }
}
