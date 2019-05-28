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

//        String day = (new SimpleDateFormat("dd")).format(userEntity.getCreatedDate().getTime());
//        System.out.println(day);
//        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss S");
////        System.out.println(sdf.format(userEntity.getCreatedDate()));
//        String dayOfWeek = new SimpleDateFormat("u").format(userEntity.getCreatedDate());
//        System.out.println(dayOfWeek);
        return userRespone;
    }
}
