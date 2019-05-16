package com.example.RikkeiCalendar.convert;

import com.example.RikkeiCalendar.entity.RoleEntity;
import com.example.RikkeiCalendar.respones.RoleResponse;

public class RoleConvert {
   public static RoleResponse convert(RoleEntity roleEntity){
       RoleResponse roleResponse=new RoleResponse();
       roleResponse.setId(roleEntity.getId());
       roleResponse.setRole(roleEntity.getRoleName());
       return roleResponse;
   }
}
