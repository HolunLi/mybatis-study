package com.holun.dao;
import com.holun.entity.Blog;
import com.holun.entity.User;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUserList();

    @Select("select * from user where name like concat(#{value}, '%')")
    List<User> selectUserByLike(String value);
}
