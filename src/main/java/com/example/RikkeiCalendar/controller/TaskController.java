package com.example.RikkeiCalendar.controller;


import com.example.RikkeiCalendar.request.BigTaskRequest;
import com.example.RikkeiCalendar.service.BigTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TaskController {
    @Autowired
    BigTaskService bigTaskService;
    @GetMapping(path = "/task")
    public String task(Model model){
        model.addAttribute("bigTask",new BigTaskRequest());
        model.addAttribute("repeatCate",cateRepeatMap());
        return "task";
    }

    @PostMapping(value = "addTask")
    private String addTask(@RequestBody BigTaskRequest bigTaskRequest, Model model){
        bigTaskService.addTask(bigTaskRequest);
        return "redirect:/homePage";
    }

    private Map<Integer,String> cateRepeatMap(){
        Map<Integer,String> map=new HashMap<>();
           map.put(0,"NONE");
           map.put(1,"DAILY");
           map.put(2,"WEEKLY");
           map.put(3,"MONTHLY");
           map.put(4,"YEARLY");
        return map;
    }
}
