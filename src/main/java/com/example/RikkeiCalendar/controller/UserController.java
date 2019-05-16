package com.example.RikkeiCalendar.controller;

import com.example.RikkeiCalendar.entity.RoleEntity;
import com.example.RikkeiCalendar.entity.UserEntity;
import com.example.RikkeiCalendar.request.UserRequest;
import com.example.RikkeiCalendar.service.RoleSerVice;
import com.example.RikkeiCalendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleSerVice roleSerVice;

    @GetMapping(path = "/viewUser")
    public String demo(Model model){
        List<UserEntity> userEntities=userService.findAll();
        model.addAttribute("user",userEntities);
        return "view_user";
    }
    @GetMapping(value = "/addForm",produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String addUser(Model model){
        model.addAttribute("userForm", new UserEntity());
        model.addAttribute("roleList",roleSerVice.findAll());
        setRoleDropDownList(model);
        return "add_user";
    }

    @RequestMapping(value = "/doAddForm",method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String doAddUser(@Valid @RequestBody UserRequest userRequest){

        userService.saveUser(userRequest);
        return "redirect:/viewUser";
    }
    private void  setRoleDropDownList(Model model){
        List<RoleEntity> roleEntityList = (List<RoleEntity>) roleSerVice.findAll();
        if (!roleEntityList.isEmpty()){
            Map<Integer, String> RoleMap = new LinkedHashMap<>();
            for (RoleEntity roleEntity:roleEntityList){
                RoleMap.put(roleEntity.getId(), roleEntity.getRoleName());
            }
            model.addAttribute("listRole", RoleMap);
        }
    }
}
