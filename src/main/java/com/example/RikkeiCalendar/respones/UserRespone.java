package com.example.RikkeiCalendar.respones;

import java.sql.Timestamp;

public class UserRespone {
    private int id;
    private String name;
    private String username;
    private String password;
    private int roleId;
    private String roleName;
    private Timestamp timestamp;
    public UserRespone() {
    }

    public UserRespone(int id, String name, String username, String password, String roleName, Timestamp timestamp) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roleName = roleName;
        this.timestamp=timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
