package com.example.RikkeiCalendar.controller;

import com.example.RikkeiCalendar.convert.TaskConvert;
import com.example.RikkeiCalendar.request.BigTaskRequest;
import com.example.RikkeiCalendar.respones.TaskReponse;
import com.example.RikkeiCalendar.service.BigTaskService;
import com.example.RikkeiCalendar.service.BigTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/task")
public class TaskRestController {
    @Autowired
    BigTaskService bigTaskService;
    @PostMapping(value = "addTask")
    private void addTask(@RequestBody BigTaskRequest bigTaskRequest){
        bigTaskService.addTask(bigTaskRequest);
    }
    @GetMapping(value = "getTasks")
    private List<TaskReponse> getTasks(){
        return  bigTaskService.getTasks().stream().map(TaskConvert::convert).collect(Collectors.toList());
    }
//    @GetMapping(value = "getTasksByDay")


}
