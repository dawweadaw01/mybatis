package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.StudentMapper;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class StudentMapperTest {
    @Test
    public void testSelectCount(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Long count = mapper.selectCount();
        System.out.println(count);
        sqlSession.close();
    }
    /**
     * map集合的主键是id，值是student对象
     * {1={sex=男, name=张三, birth=1980-10-11, id=1, age=20, height=1.81},
     * 2={sex=女, name=李四, birth=1988-10-11, id=2, age=18, height=1.61},
     * 3={sex=男, name=赵六, birth=2022-09-01, id=3, age=20, height=1.81},
     * 4={sex=男, name=赵六, birth=2022-09-01, id=4, age=20, height=1.81},
     * 5={sex=女, name=张飞, birth=2022-09-01, id=5, age=50, height=10.0},
     * 6={sex=女, name=张飞, birth=2022-09-01, id=6, age=50, height=10.0}}
     */
    @Test
    public void testSelectAllRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<Long, Map<String, Object>> map = mapper.selectAllRetMap();
        System.out.println(map);
        SqlSessionUtil.closeSession();
    }

    @Test
    public void selectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectById(1L);
        students.forEach(System.out::println);
        sqlSession.close();
    }
}
