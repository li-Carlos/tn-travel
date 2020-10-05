package com.tuniu.dao;

import com.tuniu.domain.User;

public interface UserDao {
    User findByName(String name);

    User findlikeName(String s);

    User findlikeName2(String s);
}
