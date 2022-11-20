package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Clazz;

public interface ClazzMapper {
    Clazz selectByStep(Integer cid);
    Clazz selectById(Integer cid);
    Clazz selectByCollection(Integer cid);

}
