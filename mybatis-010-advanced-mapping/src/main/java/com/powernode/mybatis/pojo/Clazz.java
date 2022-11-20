package com.powernode.mybatis.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Clazz {
    private Integer cid;
    private String cname;
    private List<Student> students;

}
