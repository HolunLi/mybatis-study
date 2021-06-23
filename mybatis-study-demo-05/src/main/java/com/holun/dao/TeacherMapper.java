package com.holun.dao;



import com.holun.entity.Student;
import com.holun.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TeacherMapper {
    //根据id查找老师
    Teacher getTeacherById(@Param("id") int id);

    //查询所有的老师
    List<Teacher> queryAllTeachers();

    //根据tid查学生
    Student getStudentByTid(@Param("tid") int tid);
}
