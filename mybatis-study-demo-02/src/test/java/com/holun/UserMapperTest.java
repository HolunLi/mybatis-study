package com.holun;

import com.holun.dao.UserMapper;
import com.holun.entity.User;
import com.holun.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.List;

public class UserMapperTest {
    private static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testSelectUserByLike() {
        SqlSession session = MybatisUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> list = userMapper.selectUserByLike("老");
        for (User user : list) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testGetUserList() {
        SqlSession session = MybatisUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> list = userMapper.getUserList();
        for (User user : list) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testLog4j() {
        logger.info("哈哈");
        logger.debug("测试");
    }
}
