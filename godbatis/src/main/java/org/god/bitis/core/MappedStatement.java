package org.god.bitis.core;

import lombok.Data;

/**
 * 封装sql标签
 */
@Data
public class MappedStatement {
    private String sql;
    private String resultType;

    public MappedStatement() {
    }

    public MappedStatement(String sql, String resultType) {
        this.sql = sql;
        this.resultType = resultType;
    }
}
