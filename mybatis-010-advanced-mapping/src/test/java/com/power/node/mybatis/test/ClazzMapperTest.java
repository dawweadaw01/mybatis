package com.power.node.mybatis.test;

import com.powernode.mybatis.mapper.ClazzMapper;
import com.powernode.mybatis.pojo.Clazz;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ClazzMapperTest {
    @Test
     public  void selectByStepTest() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByStep(1000);
        System.out.println(clazz.getStudents());
        sqlSession.close();
    }
    @Test
    public void selectByCollectionTest() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
         Clazz clazz= mapper.selectByCollection(1000);
        System.out.println(clazz);

    }
}
