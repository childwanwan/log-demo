package com.wanpp.test.entity;

import javax.persistence.*;

/**
 * Copyright (C), 2020-2020, public
 * FileName: User
 *
 * @Author: wanpp
 * @Date: 2020-03-13
 * Description: user 实体
 * Version: 1.0
 */
@Table(name = "user")
public class User {

    /**
     * 
     */
    @Id
    private String id;

    /**
     * 账号
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 昵称
     */
    @Column(name = "nickname")
    private String nickname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", password=" + password +
                ", nickname=" + nickname +
                "}";
    }
}
