package com.powernode.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class MybatisConfigurationTest {
    @Test
    public void testDataSource() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        for (int i = 0; i < 4; i++) {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("insertCar");
            sqlSession.commit();
        }
    }
}
