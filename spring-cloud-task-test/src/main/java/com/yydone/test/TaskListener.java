package com.yydone.test;

import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TaskListener {

    @PostConstruct
    public void init() {
        System.out.println("init............");
    }

    @BeforeTask
    public void methodA(TaskExecution taskExecution) {
        System.out.println("start............");
    }

    @AfterTask
    public void methodB(TaskExecution taskExecution) {
        System.out.println("end ..................");
    }
}
