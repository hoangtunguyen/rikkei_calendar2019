package com.example.RikkeiCalendar.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "user_id")
    private int userId;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "username")
    private String username;

    @JoinColumn(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    private RoleEntity role;

    @OneToMany(mappedBy = "userEntity")
    private List<TeamEntity> teamEntityList;


    @OneToMany(mappedBy = "user")
    private List<UserTeamEntity> userTeamEntities;

    @OneToMany(mappedBy = "userInTask")
    private List<UserTaskEntity> userTaskEntities;

    @OneToMany(mappedBy = "creator")
    private List<TaskEntity> ownTasks;

    @JoinColumn(name = "del_flag")
    private int delFlag;

    public UserEntity() {
    }

    public UserEntity(String name, String username, String password, RoleEntity role, List<TeamEntity> teamEntityList, List<UserTeamEntity> userTeamEntities, List<UserTaskEntity> userTaskEntities, List<TaskEntity> ownTasks, int delFlag) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.teamEntityList = teamEntityList;
        this.userTeamEntities = userTeamEntities;
        this.userTaskEntities = userTaskEntities;
        this.ownTasks = ownTasks;
        this.delFlag = delFlag;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public List<TeamEntity> getTeamEntityList() {
        return teamEntityList;
    }

    public void setTeamEntityList(List<TeamEntity> teamEntityList) {
        this.teamEntityList = teamEntityList;
    }

    public List<UserTeamEntity> getUserTeamEntities() {
        return userTeamEntities;
    }

    public void setUserTeamEntities(List<UserTeamEntity> userTeamEntities) {
        this.userTeamEntities = userTeamEntities;
    }

    public List<UserTaskEntity> getUserTaskEntities() {
        return userTaskEntities;
    }

    public void setUserTaskEntities(List<UserTaskEntity> userTaskEntities) {
        this.userTaskEntities = userTaskEntities;
    }

    public List<TaskEntity> getOwnTasks() {
        return ownTasks;
    }

    public void setOwnTasks(List<TaskEntity> ownTasks) {
        this.ownTasks = ownTasks;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
