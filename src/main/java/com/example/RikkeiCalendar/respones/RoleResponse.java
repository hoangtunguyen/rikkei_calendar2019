package com.example.RikkeiCalendar.respones;

import java.util.List;

public class RoleResponse {
    private int id;
    private String role;
    private List<String> username;
    public RoleResponse() {
    }

    public RoleResponse(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public List<String> getUsername() {
        return username;
    }

    public void setUsername(List<String> username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
