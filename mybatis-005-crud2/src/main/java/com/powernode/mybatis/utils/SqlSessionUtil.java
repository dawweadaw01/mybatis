package com.powernode.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private SqlSessionUtil() {}
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 进程内共享一个SqlSession
     */
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();
    public static SqlSession openSession() {
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭sqlSession，移除线程对象绑定关系，tomcat服务器的线程池会拿到同一个线程对象，所以需要移除绑定关系
     */
    public static void closeSession() {
        SqlSession sqlSession = local.get();
        if (sqlSession != null) {
            sqlSession.close();
            local.remove();
        }
    }




}