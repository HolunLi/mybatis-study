package com.holun.dao;

import com.holun.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    User queryUserById(@Param("id") int id);
}
