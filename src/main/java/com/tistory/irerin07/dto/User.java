package com.tistory.irerin07.dto;

import java.util.Date;

public class User {
    private Long userId;
    private String name;
    private String nickname;
    private String email;
    private String passwd;
    private Date regdate;

    public User(){

    }
    public User(String name, String nickname, String email, String passwd) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.passwd = passwd;
    }

    public User(Long userId, String nickname, String email, String passwd, Date regdate, String name) {
        this.userId = userId;
        this.nickname = nickname;
        this.email = email;
        this.passwd = passwd;
        this.regdate = regdate;
        this.name = name;

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}
