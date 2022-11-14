package org.god.bitis.utils;

import java.io.InputStream;

/**
 * godbatis提供的工具类
 * 这个工具类主要是用来获取资源文件的
 *
 * @author 帅气的杰大大
 * @version 1.0
 * @date 2022/11/13 19:00
 * @since 1.0
 */
public class Resources {
    /**
     * 构造方法私有化
     */
    private Resources() {
    }

    /**
     * 根据传入的参数，获取一个字节输入流
     * @param resource 从类路径中加载资源
     * @return  返回一个字节输入流
     */
    public static InputStream getResourceAsStream(String resource) {
        return ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
    }
}
