package com.tistory.irerin07.dao;

public class UserDAOSQL {
    public static final String INSERT = "INSERT INTO user (name, nickname, email, passwd) VALUES (?, ?, ?, ?)";
    public static final String SELECT_BY_EMAIL = "SELECT user_id, nickname, email, passwd, regdate, name FROM user WHERE email = ?";
    public static final String SELECT_ID_BY_EMAIL = "SELECT user_id FROM user WHERE email = ?";
    public static final String SELECT_NICKNAME_BY_EMAIL = "SELECT nickname FROM user WHERE email = ?";
}