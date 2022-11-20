package com.power.node.mybatis.test;

import com.powernode.mybatis.mapper.StudentMapper;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentMapperTest {
    @Test
    public void selectByIdStudentTest(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdStudent(1);
        System.out.println(student.getSname());
        sqlSession.close();
    }
    @Test
    public void selectByIdAssociation() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectByIdAssociation(1);
        System.out.println(student);
        SqlSessionUtil.closeSession();
    }
    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectById(1);
        System.out.println(student);
        SqlSessionUtil.closeSession();
    }
}
