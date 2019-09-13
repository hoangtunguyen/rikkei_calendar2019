package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.entity.UserEntity;
import com.example.RikkeiCalendar.request.UserRequest;
import com.example.RikkeiCalendar.respones.UserRespone;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<UserRespone> findAll();
    void saveUser(UserRequest request);

    UserEntity getUserById(int id);

    void updateUserById(UserRequest userRequest);

    void deleteUserById(UserRequest userRequest);
    UserEntity doLogin(String user,String pass);
    List<UserEntity> isUsernameExist(String user);
}
