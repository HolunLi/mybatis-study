package com.holun.dao;

import com.holun.entity.Student;
import com.holun.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface StudentMapper {
    //查找所有的学生
    List<Student> queryAllStudent();

    //根据学生的tid查找老师
    Teacher queryTeacherById(@Param("tid") int tid);
}
