package com.tistory.irerin07.service;

import com.tistory.irerin07.dto.User;

public interface UserService {
    void addUser(User user);

    User getUserByEmail(String email);
}
