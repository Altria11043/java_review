package com.zca.reflection.bean;

/**
 * @author Altria
 * Date: 10/10/2019 上午 9:19
 */
public class User {
    private int id;
    private String uname;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(int id, String uname, int age) {
        this.id = id;
        this.uname = uname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
    }
}
