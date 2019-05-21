package com.example.RikkeiCalendar.controller;

import com.example.RikkeiCalendar.request.BigTaskRequest;
import com.example.RikkeiCalendar.service.BigTaskService;
import com.example.RikkeiCalendar.service.BigTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/task")
public class TaskRestController {
    @Autowired
    BigTaskService bigTaskService;
    @PostMapping(value = "addTask")
    private void addTask(@RequestBody BigTaskRequest bigTaskRequest){
        bigTaskService.addTask(bigTaskRequest);
    }
}
