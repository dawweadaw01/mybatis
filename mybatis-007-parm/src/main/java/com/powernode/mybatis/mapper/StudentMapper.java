package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    Long selectCount();
    List<Student> selectById(Long id);
    List<Student> selectByName(String name);
    @MapKey("id")
    Map<Long , Map<String, Object>> selectAllRetMap();
}
