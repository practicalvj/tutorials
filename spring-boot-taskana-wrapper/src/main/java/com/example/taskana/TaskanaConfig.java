package com.example.taskana;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

import pro.taskana.TaskanaEngine;
import pro.taskana.TaskanaEngineConfiguration;

@Configuration
public class TaskanaConfig {

    @Bean
    public TaskanaEngine taskanaEngine(DataSource dataSource) throws Exception {
        TaskanaEngineConfiguration configuration = new TaskanaEngineConfiguration(dataSource, false, false);
        return configuration.buildTaskanaEngine();
    }
}
