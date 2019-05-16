package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.entity.RoleEntity;
import com.example.RikkeiCalendar.request.RoleRequest;

import java.util.List;

public interface RoleSerVice {
    List<RoleEntity> findAll();
    void saveRole(RoleRequest roleRequest);
    List<RoleEntity> getAllRole();
}
