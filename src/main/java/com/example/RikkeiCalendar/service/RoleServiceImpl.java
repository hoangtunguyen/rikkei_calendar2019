package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.entity.RoleEntity;
import com.example.RikkeiCalendar.repository.RoleRepository;
import com.example.RikkeiCalendar.request.RoleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleSerVice {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<RoleEntity> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void saveRole(RoleRequest roleRequest) {
        RoleEntity roleEntity=new RoleEntity();
        roleEntity.setRoleName(roleRequest.getRole());
         roleRepository.save(roleEntity);
    }
    @Override
    public List<RoleEntity> getAllRole() {
        return roleRepository.getAllRole();
    }
}
