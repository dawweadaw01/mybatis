package com.powernode.mybatis.test;

import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class CarMapperTest {
    @Test
    public void testInsertCarByUtil(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertCar");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertCar() {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //开启会话
            sqlSession = sqlSessionFactory.openSession();
            //执行sql语句
            int count = sqlSession.insert("insertCar");
            System.out.println(count);
            sqlSession.commit();
        } catch (Exception ex) {
            //回滚事务
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
