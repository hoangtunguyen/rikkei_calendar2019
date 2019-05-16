package com.example.RikkeiCalendar.request;

public class UserRequest {
    private int id;
    private String name;
    private String username;
    private String password;
    private int roleId;


    public UserRequest() {
    }

    public UserRequest(int id, String name, String username, String password, int roleId) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
