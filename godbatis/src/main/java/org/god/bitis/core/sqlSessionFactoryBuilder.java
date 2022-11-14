package org.god.bitis.core;

import java.io.InputStream;

/**
 *sqlSessionFactory构造器对象
 * 通过build方法，传入一个字节输入流，获取一个sqlSessionFactory对象
 * @author 帅气的杰大大
 * @version 1.0
 */
public class sqlSessionFactoryBuilder {
    public sqlSessionFactoryBuilder() {
    }

    public sqlSessionFactory build(InputStream inputStream) {
        sqlSessionFactory factory = new sqlSessionFactory();
        return factory;
    }
}
