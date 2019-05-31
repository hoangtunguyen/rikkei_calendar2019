package com.example.RikkeiCalendar.convert;

import com.example.RikkeiCalendar.entity.UserEntity;
import com.example.RikkeiCalendar.respones.UserRespone;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class UserConvert {
    public static UserRespone convert(UserEntity userEntity){
        UserRespone userRespone=new UserRespone();
        userRespone.setId(userEntity.getUserId());
        userRespone.setName(userEntity.getName());
        userRespone.setUsername(userEntity.getUsername());
        userRespone.setPassword(userEntity.getPassword());
        userRespone.setRoleName(userEntity.getRole().getRoleName());
        userRespone.setRoleId(userEntity.getRole().getId());
        userRespone.setTimestamp(userEntity.getCreatedDate());
        return userRespone;
    }
}
