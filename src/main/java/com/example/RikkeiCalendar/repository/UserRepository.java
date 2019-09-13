package com.example.RikkeiCalendar.repository;

import com.example.RikkeiCalendar.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    List<UserEntity> findAllByDelFlagNot(int delValue);
    UserEntity findByUsernameAndPassword(String user, String pass);
    List<UserEntity> findAllByUsername(String user);
}
