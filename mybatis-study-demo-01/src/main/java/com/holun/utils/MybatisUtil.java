package com.holun.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //通过SqlSessionFactoryBuilder对象创建SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //有了SqlSessionFactory后,就可以从中获取SqlSession对象(SqlSession对象就是prepareStatement对象,通过该对象执行sql语句)
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession(true); //在获取sqlSession时,设置自动提交事务。后面在执行增删改操作后,就不需要再手动的提交事务了
    }
}
