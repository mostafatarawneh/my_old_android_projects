package com.mos.fulldemo;

public class User {
    int id;
    String username;
    String password;
    String age;
    String work;
    int img;

    public User(int id, String username, String password, String age, String work, int img) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.work = work;
        this.img = img;
    }

    public User(int id, String username, String password, String age, String work) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.work = work;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
