package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * com.example.demo.entity
 *
 * @author xzwnp
 * 2021/10/23
 * 16:18
 * @Description ：
 * Steps：
 */
@Entity
@Table(name = "User_Inf")
public class User {
    //注意：spring要求所有变量名小写！
    @Id
    private String id;
    @Column(length = 50)
    private String password;
    @Column(length = 20)
    private String name;
    private boolean sex;
    private int age;

    public User() {
    }

    public User(String id, String password, String name, boolean sex, int age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
