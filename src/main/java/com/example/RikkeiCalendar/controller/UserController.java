package com.example.RikkeiCalendar.controller;

import com.example.RikkeiCalendar.entity.RoleEntity;
import com.example.RikkeiCalendar.entity.UserEntity;
import com.example.RikkeiCalendar.request.UserRequest;
import com.example.RikkeiCalendar.respones.UserRespone;
import com.example.RikkeiCalendar.service.RoleSerVice;
import com.example.RikkeiCalendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
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
        List<UserRespone> userEntities=userService.findAll();
        model.addAttribute("users",userEntities);
        model.addAttribute("user",new UserRequest());
        Map<Integer,String> mapRoles=setRoleDropDownList();
        model.addAttribute("roleList",mapRoles);
        return "profile_user";
    }
    @PostMapping(path = "/doSaveUser")
    public String doSaveUser(@ModelAttribute UserRequest userRequest){
        userService.saveUser(userRequest);
        return "redirect:/viewUser";
    }
    @GetMapping(path = "/deleteUser/{id}")
    public String deleteUser(RedirectAttributes model, @PathVariable int id, @ModelAttribute UserRequest userRequest){
        userRequest.setId(id);
        userService.deleteUserById(userRequest);
//        model.addFlashAttribute("msg","Success");
        return "redirect:/viewUser";
    }


    private Map<Integer,String> setRoleDropDownList(){
        List<RoleEntity> roleEntityList = (List<RoleEntity>) roleSerVice.findAll();
        Map<Integer,String> map=new HashMap<Integer, String>();

        if (!roleEntityList.isEmpty()){
            for (RoleEntity roleEntity:roleEntityList){
                map.put(roleEntity.getId(), roleEntity.getRoleName());
            }

        }
        return map;
    }


    @GetMapping(path = "/login")
    public String login(Model model){
        model.addAttribute("users",new UserEntity());
        return "login";
    }
    @PostMapping(path = "/doLogin")
    public String doLogin(@ModelAttribute UserEntity user,
                          HttpServletRequest request){
        UserEntity userEntity=userService.doLogin(user.getUsername(),user.getPassword());
        HttpSession session=request.getSession();
        session.setAttribute("userInfor",userEntity);
        if (userEntity!=null) {
            return "redirect:/homePage";
        }
        return "redirect:/login";
    }
}
