package org.god.bitis.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 杰
 * @version 1.0
 * @since 1.0
 */
public class sqlSessionFactory {
    /**
     * 事务管理器
     * sqlSession工厂对象中，包含了一个事务管理器
     * 事务管理器的作用是，控制事务的提交，回滚，关闭
     */
    private Transaction transaction;

/**
 * 数据源
 */

    /**
     * 存放sql的map集合
     * key:sqlId
     * value:sql标签信息对象
     */
    private Map<String, MappedStatement> mappedStatementMap;
}
