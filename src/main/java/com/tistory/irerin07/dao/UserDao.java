package com.tistory.irerin07.dao;

import com.tistory.irerin07.dto.User;

public interface UserDao {
    void addUser(User user);

    String getPasswdByEmail(String email);

    public Long getIdByEmail(String email);

    String getNickNameByEmail(String email);
}