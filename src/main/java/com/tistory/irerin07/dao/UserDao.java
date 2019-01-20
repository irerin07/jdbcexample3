package com.tistory.irerin07.dao;

import com.tistory.irerin07.dto.User;

public interface UserDao {
    void addUser(User user);

    User getUserByEmail(String email);

}