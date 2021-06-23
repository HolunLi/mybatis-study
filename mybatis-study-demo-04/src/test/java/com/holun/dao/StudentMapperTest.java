package com.holun.dao;

import com.holun.entity.Student;
import com.holun.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {

    @Test
    public void testQueryAllStudent() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.queryAllStudent();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
