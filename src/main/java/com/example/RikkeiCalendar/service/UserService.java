package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<UserEntity> findAll();

}
