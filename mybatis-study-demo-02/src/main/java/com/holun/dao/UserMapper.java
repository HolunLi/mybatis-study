package com.holun.dao;

import com.holun.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();
    List<User> selectUserByLike(String mes);
}
