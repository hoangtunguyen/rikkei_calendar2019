package com.example.RikkeiCalendar.controller;

import com.example.RikkeiCalendar.request.RoleRequest;
import com.example.RikkeiCalendar.service.RoleSerVice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RoleController {

    public static final String ADD_ROLE_VIEW = "add_role";
    @Autowired
    private RoleSerVice roleSerVice;

    @GetMapping(name = "/addRole", produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ModelAndView addRole(){
        ModelAndView modelAndView=new ModelAndView(ADD_ROLE_VIEW);
        modelAndView.addObject("role", new RoleRequest());
        return modelAndView;
    }
    @PostMapping(name = "/doAddRole",produces = {
            MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String doAddRole(@ModelAttribute RoleRequest request){
        roleSerVice.saveRole(request);
        return "redirect:/addRole";
    }
}
