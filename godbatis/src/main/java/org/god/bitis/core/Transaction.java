package org.god.bitis.core;

/**
 * 事务管理器
 * @author 杰
 * @version 1.0
 * @since 1.0
 */
public interface Transaction {
    //提供控制事务的方法
    void commit();
    void rollback();
    void close();

}
