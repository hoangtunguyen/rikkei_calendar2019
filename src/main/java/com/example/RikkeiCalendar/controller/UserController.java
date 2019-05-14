package com.example.RikkeiCalendar.controller;

import com.example.RikkeiCalendar.entity.UserEntity;
import com.example.RikkeiCalendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

        @GetMapping(path = "/viewUser")
    public String demo(Model model){
        List<UserEntity> userEntities=userService.findAll();
        model.addAttribute("user",userEntities);
        return "view_user";
    }
}
