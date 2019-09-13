package com.example.RikkeiCalendar.controller;

import com.example.RikkeiCalendar.convert.RepeatCategoryConvert;
import com.example.RikkeiCalendar.respones.RepeatCategoryResponse;
import com.example.RikkeiCalendar.service.RepeatCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/rep")
public class RepeatRestController {
    @Autowired
    RepeatCateService repeatCateService;

    @GetMapping(value = "/getRepeats")
        public List<RepeatCategoryResponse> getRepeats() {
        return repeatCateService.findAll().stream().map(RepeatCategoryConvert::convert).collect(Collectors.toList());
    }
}
