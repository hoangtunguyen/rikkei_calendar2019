package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.entity.UserEntity;
import com.example.RikkeiCalendar.repository.RoleRepository;
import com.example.RikkeiCalendar.repository.UserRepository;
import com.example.RikkeiCalendar.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    @Override
    public void saveUser(UserRequest request) {
        UserEntity userEntity=new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        userEntity.setRole(roleRepository.findById(request.getRoleId()).get());
         userRepository.save(userEntity);
    }
}
