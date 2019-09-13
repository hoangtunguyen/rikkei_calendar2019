package com.example.RikkeiCalendar.controller;

import com.example.RikkeiCalendar.convert.RoleConvert;
import com.example.RikkeiCalendar.convert.UserConvert;
import com.example.RikkeiCalendar.request.RoleRequest;
import com.example.RikkeiCalendar.request.UserRequest;
import com.example.RikkeiCalendar.respones.RoleResponse;
import com.example.RikkeiCalendar.respones.UserRespone;
import com.example.RikkeiCalendar.service.RoleSerVice;
import com.example.RikkeiCalendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleSerVice roleSerVice;
//   Error 406 if we use 2 lines below
//    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
//            MediaType.APPLICATION_XML_VALUE})
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<UserRespone> getUsers() {
        return userService.findAll();
    }
    @GetMapping(path = "/getRoles")
    public List<RoleResponse> getRoles() {
        return roleSerVice.getAllRole().stream().map(RoleConvert::convert).collect(Collectors.toList());
    }

    @PostMapping(value = "/addUser")
    public void saveUser(@RequestBody UserRequest userRequest) {
        userService.saveUser(userRequest);
    }


        @PostMapping(value = "/addRole")
    public void saveRole(@RequestBody RoleRequest roleRequest) {
        roleSerVice.saveRole(roleRequest);
    }

    @PutMapping(path = "/updateUser")
    public void updateUser(@Valid @RequestBody UserRequest userRequest) {
        userService.updateUserById(userRequest);
    }
    @PutMapping(path = "/deleteUser")
    public void deleteUser(@Valid @RequestBody UserRequest userRequest) {
        userService.deleteUserById(userRequest);

    }

}
