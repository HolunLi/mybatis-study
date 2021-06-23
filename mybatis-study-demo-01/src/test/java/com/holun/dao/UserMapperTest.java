package com.holun.dao;

import com.holun.entity.User;
import com.holun.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void testGetUserList() {
        SqlSession sqlSession =  MybatisUtil.getSqlSession();
        /*方法一*/
        //获取UserDao接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.getUserList();
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println();

        //方法二(不建议使用)
        /*
        List<User> list1 = sqlSession.selectList("com.holun.dao.UserMapper.getUserList");
        for (User user1 : list) {
            System.out.println(user1);
        }*/
        sqlSession.close();
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession =  MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(4);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testAddUser() {
        SqlSession sqlSession =  MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int count = userMapper.addUser(new User(4, "杜一炜", "du123"));
        if (count > 0) {
            System.out.println("添加成功!");
        }

        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession =  MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("id", 4);
        map.put("pwd", "9527");
        userMapper.updateUser(map);

        sqlSession.close();
    }

    @Test
    public void testDeleteUserById() {
        SqlSession sqlSession =  MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.deleteUserById(2);
        sqlSession.close();
    }

    @Test
    public void testSelectUserByLike() {
        SqlSession sqlSession =  MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = userMapper.selectUserByLike("老");
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
