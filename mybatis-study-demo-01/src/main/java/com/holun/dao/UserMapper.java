package com.holun.dao;

import com.holun.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(@Param("id") int id);

    int addUser(User user);

    void updateUser(Map<String, Object> map);

    void deleteUserById(@Param("id") int id);

    List<User> selectUserByLike(String mes);
}
