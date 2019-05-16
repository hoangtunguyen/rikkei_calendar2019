package com.example.RikkeiCalendar.repository;

import com.example.RikkeiCalendar.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {

    @Query("select r from #{#entityName} r")
    List<RoleEntity> getAllRole();
}
