package com.holun.dao;

import com.holun.entity.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    List<Blog> queryBlogByAuthor(String value);

    int addBlog(Blog blog);

    List<Blog> queryBlogByIf(Map map);

    List<Blog> queryBlogByChoose(Map map);

    List<Blog> queryBlogByForeach(List list);

    int updateBlogById(Map map);
}
