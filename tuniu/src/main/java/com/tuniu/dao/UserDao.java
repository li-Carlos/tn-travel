package com.tuniu.dao;

import com.tuniu.domain.User;

public interface UserDao {
    User findByName(String name);
}
