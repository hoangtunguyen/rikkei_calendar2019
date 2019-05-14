package com.example.RikkeiCalendar.test;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "testuser")
public class UserTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;

    @JoinColumn(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserTest userTest;

    @OneToMany(mappedBy = "userTest")
    private List<UserTest> userTests;

    public UserTest() {
    }

    public UserTest(String name, UserTest userTest, List<UserTest> userTests) {
        this.name = name;
        this.userTest = userTest;
        this.userTests = userTests;
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

    public UserTest getUserTest() {
        return userTest;
    }

    public void setUserTest(UserTest userTest) {
        this.userTest = userTest;
    }

    public List<UserTest> getUserTests() {
        return userTests;
    }

    public void setUserTests(List<UserTest> userTests) {
        this.userTests = userTests;
    }
}
