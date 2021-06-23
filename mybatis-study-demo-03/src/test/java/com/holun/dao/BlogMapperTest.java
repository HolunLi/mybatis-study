package com.holun.dao;

import com.holun.entity.Blog;
import com.holun.utils.IDUtil;
import com.holun.utils.MybatisUtil;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogMapperTest {

    @Test
    public void testQueryBlogByForeach() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Integer> myList = new ArrayList();
        myList.add(3);
        myList.add(1);
        myList.add(2);
        myList.add(9);
        List<Blog> blogs = mapper.queryBlogByForeach(myList);
        blogs.forEach(System.out :: println);
        sqlSession.close();
        Cache
    }

    @Test
    public void testUpdateBlogById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map map = new HashMap();
        map.put("author", "易中天");
        map.put("title", "一夜知州");
        map.put("id", "9fc5c1d796b747c2a63619f251aa7c5d");
        int i = mapper.updateBlogById(map);
        if (i > 0)
            System.out.println("修改成功!");
    }

    @Test
    public void testQueryBlogByChoose() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, String> map = new HashMap<>();
        //map.put("author", "李神");
        //map.put("title", "SpringBoot");
        List<Blog> blogs = mapper.queryBlogByChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void testQueryBlogByIf() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, String> map = new HashMap<>();
        //map.put("author", "李神");
        map.put("title", "SpringBoot");
        List<Blog> blogs = mapper.queryBlogByIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void testQueryBlogByAuthor() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogs = mapper.queryBlogByAuthor("李神");
        blogs.forEach(System.out :: println);
        sqlSession.close();
    }

    @Test
    public void testAddBlog() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        mapper.addBlog(new Blog(IDUtil.getId(),"SpringBoot", "狂神", new Date(), 52345));
        sqlSession.close();
    }
}
