package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.entity.UserEntity;
import com.example.RikkeiCalendar.repository.RoleRepository;
import com.example.RikkeiCalendar.repository.UserRepository;
import com.example.RikkeiCalendar.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public static final int DEL_VALUE = 1;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAllByDelFlagNot(DEL_VALUE);

    }

    @Override
    public void saveUser(UserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        userEntity.setRole(roleRepository.findById(request.getRoleId()).get());
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void updateUserById(int userId, UserRequest userRequest) {
        UserEntity user = userRepository.findById(userId).get();
        user.setRole(roleRepository.findById(userRequest.getRoleId()).get());
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);

    }
}
