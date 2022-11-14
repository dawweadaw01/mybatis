package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) throws IOException {
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        int count = sqlSession.insert("insertCar");
        System.out.println("输入了几条记录"+count);
        //提交事务
        //sqlSession.commit();

    }
}
