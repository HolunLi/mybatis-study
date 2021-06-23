package com.holun.dao;

import com.holun.entity.User;
import com.holun.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {
    @Test
    public void testUserMapperTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        /*
        在同一次sqlSession中，查询的数据会被保存到本地缓存,本地缓冲默认是开启的。
        二级缓存手动开启后,位于本地缓存中的数据会被存放到二级缓存中，因此扩大了缓存中数据的作用域。
        因此在开启二级缓存后,再执行查询语句,会先从二级缓存中找要查询的数据,二级缓存中没有找到，再从被本地缓存中找，
        如果本地缓存中也没查找到,说明这条查询语句之前没被执行(新的查询语句)，因此没被缓存，所以最终从数据库中找要查询的数据。
        本地缓存类似于局部缓存，而二级缓存是全句缓存。
        */
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.queryUserById(1);
        //同一条查询语句执行第二次,不是再是从数据库中查询,而是直接从二级缓存中查询的。
        User user2 = mapper.queryUserById(1);
        User user3 = mapper.queryUserById(3);
        System.out.println(user1 == user2); //true
        System.out.println(user3);
    }
}
