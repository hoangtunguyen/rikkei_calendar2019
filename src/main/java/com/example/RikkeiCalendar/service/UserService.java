package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.entity.UserEntity;
import com.example.RikkeiCalendar.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<UserEntity> findAll();
    void saveUser(UserRequest request);

    UserEntity getUserById(int id);

    void updateUserById(int userId, UserRequest userRequest);
}
