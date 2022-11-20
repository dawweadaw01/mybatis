package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectByStep2();
    Student selectById(Integer sid);

    Student selectByIdAssociation(Integer sid);

    Student selectByIdStudent(Integer sid);
}
