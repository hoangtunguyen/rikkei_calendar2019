package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.convert.UserConvert;
import com.example.RikkeiCalendar.entity.UserEntity;
import com.example.RikkeiCalendar.repository.RoleRepository;
import com.example.RikkeiCalendar.repository.UserRepository;
import com.example.RikkeiCalendar.request.UserRequest;
import com.example.RikkeiCalendar.respones.UserRespone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public static final int DEL_VALUE = 1;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<UserRespone> findAll() {
        return userRepository.findAllByDelFlagNot(DEL_VALUE).stream().map(UserConvert::convert).collect(Collectors.toList());

    }

    @Override
    public void saveUser(UserRequest request) {
        UserEntity user;
        if (request.getId()!=0){
            user = userRepository.findById(request.getId()).get();
        }else {
            user = new UserEntity();
        }

        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(roleRepository.findById(request.getRoleId()).get());
        userRepository.save(user);

    }

    @Override
    public UserEntity getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void updateUserById(UserRequest userRequest) {
        UserEntity user = userRepository.findById(userRequest.getId()).get();
        user.setRole(roleRepository.findById(userRequest.getRoleId()).get());
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);

    }

    @Override
    public void deleteUserById(UserRequest userRequest) {
        UserEntity user = userRepository.findById(userRequest.getId()).get();
        user.setDelFlag(DEL_VALUE);
        userRepository.save(user);
    }

    @Override
    public UserEntity doLogin(String user, String pass) {
        UserEntity userEntity=userRepository.findByUsernameAndPassword(user,pass);
        return userEntity;
    }

    @Override
    public List<UserEntity> isUsernameExist(String user) {
        return userRepository.findAllByUsername(user);
    }
}
