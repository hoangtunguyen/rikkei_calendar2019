package com.example.RikkeiCalendar.convert;

import com.example.RikkeiCalendar.entity.RoleEntity;
import com.example.RikkeiCalendar.entity.UserEntity;
import com.example.RikkeiCalendar.respones.RoleResponse;

import java.util.ArrayList;
import java.util.List;

public class RoleConvert {
   public static RoleResponse convert(RoleEntity roleEntity){
       RoleResponse roleResponse=new RoleResponse();
       List<String> username=new ArrayList<>();
       for (UserEntity userEntity: roleEntity.getUsers()){
           username.add(userEntity.getName());
       }
       roleResponse.setId(roleEntity.getId());
       roleResponse.setRole(roleEntity.getRoleName());
       roleResponse.setUsername(username);
       return roleResponse;
   }
}
