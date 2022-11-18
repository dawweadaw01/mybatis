package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;

import java.util.List;

public interface CarMapper {

    List<Car> selectByCarType(String carType);

    int deleteBatch(String ids);
    List<Car> selectByCar(String carType);

}
