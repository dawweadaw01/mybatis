package com.powernode.mybatis.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private Double height;
    private Date birth;
    private Character sex;
}
